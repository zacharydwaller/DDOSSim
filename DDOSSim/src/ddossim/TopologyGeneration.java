/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Zachary Waller
 */
public class TopologyGeneration
{
    // Generate a topology with 20 routers with 4 branches and 9 hops
    public static List<Router> Generate(INode victim, int numRouters)
    {
        Random rand = new Random();
        ArrayList<Router> list = new ArrayList<>();
        SimMgr mgr = SimMgr.GetInstance();
        
        // Create root and first chain
        Router root = new Router(mgr.GetNextAddress(), victim);
        list.add(root);
        list.addAll(CreateChain(root, 3));
        
        // Create first split at depth = 4 and chains along split
        ArrayList<Router> splitChildren = new ArrayList<>(CreateSplit(list.get(list.size() - 1), 2));
        for(int i = 0; i <  2; i++)
        {
            // Should have done this recursively
            Router splitRoot = splitChildren.get(i);
            splitChildren.addAll(CreateChain(splitRoot, 2));
            
            // Create second split at depth = 6
            ArrayList<Router> subsplitChildren = new ArrayList<>(CreateSplit(splitChildren.get(splitChildren.size() - 1), 2));
            for(int j = 0; j < 2; j++)
            {
                // Definitely should have done this recursively
                Router subsplitRoot = subsplitChildren.get(j);
                subsplitChildren.addAll(CreateChain(subsplitRoot, 2));
            }
            
            splitChildren.addAll(subsplitChildren);
        }
        list.addAll(splitChildren);
        
        return list;
    }
    
    // Creates chain from root, returned list does not contain root
    private static List<Router> CreateChain(Router root, int length)
    {
        SimMgr mgr = SimMgr.GetInstance();
        ArrayList<Router> chain = new ArrayList<>();
        Router curRoot = root;
        
        for(int i = 0; i < length; i++)
        {            
            Router child = new Router(mgr.GetNextAddress(), curRoot);
            curRoot.AddChild(child);
            chain.add(child);
            
            curRoot = child;
        }
        
        return chain;
    }
    
    // Creates numChildren wide split at root, returned list does not contain root
    private static List<Router> CreateSplit(Router root, int numChildren)
    {
        SimMgr mgr = SimMgr.GetInstance();
        ArrayList<Router> split = new ArrayList<>();
        
        for(int i = 0; i < numChildren; i++)
        {
            Router child = new Router(mgr.GetNextAddress(), root);
            root.AddChild(child);
            split.add(child);
        }
        
        return split;
    }
}
