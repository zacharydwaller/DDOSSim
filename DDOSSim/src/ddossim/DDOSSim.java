/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 * 
 * Usage:
 * @param args topologyFile markingAlgorithm markingProb users attackers attackRate
 * Example: java DDOSSim top1.top E 0.6 5 1 100
 * markingAlgorithm: N for Node Sampling, E for Edge Sampling
 * markingProb: .2, .4, .5, .6, or .8
 * users: 1 or 2
 * attackers: 1 or 2
 * attackRate: 10, 100, or 1000
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class DDOSSim
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        SimMgr mgr = SimMgr.GetInstance();
        if (mgr.Initialize(args))
        {
            mgr.PressEnterToContinue();
            mgr.Run();
        }
        else
        {
            System.out.println("Simulation failed to initialize.");
        }
    }

    
}
