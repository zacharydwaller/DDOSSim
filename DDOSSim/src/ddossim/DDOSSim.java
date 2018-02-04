/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 * 
 * Usage:
 * @param args markingAlgorithm markingProb branches attackers attackRate
 * Example: java DDOSSim E 0.6 5 1 100
 * markingAlgorithm: N for Node Sampling, E for Edge Sampling
 * markingProb: .2, .4, .5, .6, or .8
 * branches: 3, 4, or 5
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
        SimMgr mgr = new SimMgr();
        if (mgr.Initialize(args))
        {
            mgr.Run();
        }
        else
        {
            System.out.println("Simulation Manager failed to initialize.");
        }
    }

}
