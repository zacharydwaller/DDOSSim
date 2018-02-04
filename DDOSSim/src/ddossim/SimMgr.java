/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class SimMgr {
    
    // Server Victim
    // List<Attackers>
    
    private float markingProbability;
    private int branches;
    private int numAttackers;
    private int attackRate; // x times more packets per update than normal client
    private AlgorithmType algorithm;
    
    private int numRouters = 20;
    
    private boolean isRunning = false;

    public float GetMarkingProbability() { return markingProbability; }
    public float GetAttackMultiplier() { return attackRate; }
    public AlgorithmType GetAlgorithm() { return algorithm; }
    
    public SimMgr()
    {
        
    }
    
    public boolean Initialize(String[] args)
    {
        if(!TryParseArgs(args))
        {
            return false;
        }
        
        return true;
    }
    
    public void Run()
    {
        System.out.println("Running");
        
        isRunning = true;
        while(isRunning)
        {
            Update();
        }
        
        System.out.println("Simulation ending");
    }
    
    public void Stop()
    {
        isRunning = false;
    }
    
    private void Update()
    {
        // for each user, attacker: update
        // server update
        
        Stop();
    }
    
    /**
     * @param args
     */
    private boolean TryParseArgs(String[] args)
    {
        int arg = 0;
        
        try
        {
            // Check arg count
            if(args.length < 5)
            {
                throw new IllegalArgumentException("Illegal arg count.\n Expected Args: markingAlgorithm('E' or 'N') markingProb branches attackers attackRate");
            }
            
            // Get algorithm type
            char algFlag = args[arg].toUpperCase().charAt(0);
            arg++;
            
            if(algFlag == 'E')
            {
                algorithm = AlgorithmType.EdgeSampling;
            }
            else if(algFlag == 'N')
            {
                algorithm = AlgorithmType.NodeSampling;
            }
            else
            {
                throw new IllegalArgumentException("Algorithm Type is invalid. Use 'E' or 'N'.");
            }
            
            // Marking prob
            markingProbability = Float.parseFloat(args[arg]);
            arg++;
            
            if(markingProbability <= 0.0f || markingProbability >= 1.0f)
            {
                throw new IllegalArgumentException("Marking probability must be between 0 and 1.");
            }
            
            // Branches
            branches = Integer.parseInt(args[arg]);
            arg++;
            
            if(branches < 3 || branches > 5)
            {
                throw new IllegalArgumentException("Branches must be between 3 and 5.");
            }
            
            // Attackers
            numAttackers = Integer.parseInt(args[arg]);
            arg++;
            
            if(numAttackers < 1 || numAttackers > 2)
            {
                throw new IllegalArgumentException("Number of Attackers must be between 1 and 2.");
            }
            
            // Attack rate
            attackRate = Integer.parseInt(args[arg]);
            arg++;
            
            if(attackRate <= 1)
            {
                throw new IllegalArgumentException("Attack Rate should be greater than 1.");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
        System.out.println("Simulation initalized");
        
        return true;
    }
}
