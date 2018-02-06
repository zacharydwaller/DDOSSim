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
    private static final int minChildren = 1;
    private static final int maxChildren = 3;
    
    // Generate a topology with n routers with a branching factor of 1-3
    // Generates breadth-first until there are n routers
    static List<Router> Generate(INode victim, int numRouters)
    {
        Random rand = new Random();
        ArrayList<Router> list = new ArrayList<>();
        SimMgr mgr = SimMgr.GetInstance();
        
        Router root = new Router(mgr.GetNextAddress(), victim);
        list.add(root);
            
        int index = 0;
        while(list.size() < numRouters)
        {
            // Create 1-3 children
            root = list.get(index);
            int childCount = Math.abs(rand.nextInt()) % (maxChildren + 1 - minChildren) + minChildren;
            for(int i = 0; i < childCount && list.size() < numRouters; i++)
            {
                Router child = new Router(mgr.GetNextAddress(), root);
                root.AddChild(child);
                list.add(child);
            }
            index++;
        }
        
        return list;
    }
}