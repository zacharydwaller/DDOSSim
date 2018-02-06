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
    private static final int minChildren = 0;
    private static final int maxChildren = 2;
    
    // Generate a topology with n routers with a branching factor of 1-2
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
            index = rand.nextInt(list.size());
            root = list.get(index);
            
            if(root.ChildCount() >= maxChildren) continue;
            
            Router child = new Router(mgr.GetNextAddress(), root);
            root.AddChild(child);
            list.add(child);
        }
        
        return list;
    }
}
