/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.List;

/**
 *
 * @author Zachary Waller
 */
public class SimMgr
{

    private Server victim;
    private List<Router> routers;
    // List<Clients>
    
    private float markingProbability;
    private int branches;
    private int numAttackers;
    private int attackRate; // x times more packets per update than normal client
    private AlgorithmType samplingAlgorithm;

    private int lastUsedAddress = 0;
    private final int addressStride = 10;
    
    private final int numRouters = 20;

    private boolean isRunning = false;

    public float GetMarkingProbability()
    {
        return markingProbability;
    }

    public float GetAttackMultiplier()
    {
        return attackRate;
    }

    public AlgorithmType GetAlgorithm()
    {
        return samplingAlgorithm;
    }
    
    public boolean Initialize(String[] args)
    {
        if (!TryParseArgs(args))
        {
            return false;
        }
        
        victim = new Server(GetNextAddress(), samplingAlgorithm);
        routers = TopologyGeneration.Generate(victim, numRouters);

        PrintTopology();
        
        return true;
    }

    public void Run()
    {
        System.out.println("Running");

        isRunning = true;
        while (isRunning)
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
        
        victim.Update();
        Stop();
    }

    public int GetNextAddress()
    {
        lastUsedAddress += addressStride;
        return lastUsedAddress;
    }
    
    public void PrintTopology()
    {
        System.out.println("Victim has an address of: " + victim.GetAddress());
        System.out.println("Topology:");
        System.out.println(victim.toString());
        for(Router router : routers)
        {
            System.out.println(router.toString());
        }
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
            if (args.length < 5)
            {
                throw new IllegalArgumentException("Illegal arg count.\n Expected Args: markingAlgorithm('E' or 'N') markingProb branches attackers attackRate");
            }

            // Get algorithm type
            char algFlag = args[arg].toUpperCase().charAt(0);
            arg++;

            if (algFlag == 'E')
            {
                samplingAlgorithm = AlgorithmType.EdgeSampling;
            }
            else
            {
                if (algFlag == 'N')
                {
                    samplingAlgorithm = AlgorithmType.NodeSampling;
                }
                else
                {
                    throw new IllegalArgumentException("Algorithm Type is invalid. Use 'E' or 'N'.");
                }
            }

            // Marking prob
            markingProbability = Float.parseFloat(args[arg]);
            arg++;

            if (markingProbability <= 0.0f || markingProbability >= 1.0f)
            {
                throw new IllegalArgumentException("Marking probability must be between 0 and 1.");
            }

            // Branches
            branches = Integer.parseInt(args[arg]);
            arg++;

            if (branches < 3 || branches > 5)
            {
                throw new IllegalArgumentException("Branches must be between 3 and 5.");
            }

            // Attackers
            numAttackers = Integer.parseInt(args[arg]);
            arg++;

            if (numAttackers < 1 || numAttackers > 2)
            {
                throw new IllegalArgumentException("Number of Attackers must be between 1 and 2.");
            }

            // Attack rate
            attackRate = Integer.parseInt(args[arg]);
            arg++;

            if (attackRate <= 1)
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
    
    /* Singleton Pattern */
    
    private static SimMgr instance = null;
    
    protected SimMgr() {}
    
    public static SimMgr GetInstance()
    {
        if(instance == null)
        {
            instance = new SimMgr();
        }
        return instance;
    }
        
}
