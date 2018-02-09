/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author Zachary Waller
 */
public class EdgeSampler implements ISampler
{

    private HashMap<Integer, EdgeTuple> edges;
    private int rootAddress;
    
    public EdgeSampler(int rootAddress)
    {
        this.rootAddress = rootAddress;
        edges = new HashMap<>();
    }
    
    @Override
    public void LogPacket(IPacket packet)
    {
        EdgePacket edgePacket = (EdgePacket) packet;
        if(edgePacket.GetDistance() == 0)
        {
            edgePacket.SetEdgeEnd(rootAddress);
        }
        
        EdgeTuple tuple = new EdgeTuple(edgePacket);
        edges.put(tuple.hashCode(), tuple);
    }
    
    public List<EdgeTuple> ReconstructPath()
    {
        List<EdgeTuple> path = new ArrayList<>(edges.values());
        Collections.sort(path, new EdgeCompare());
        
        return path;
        
        /*
        int distance = -1;
        
        EdgeTuple root = null;
        do
        {
            root = edges.higher(new EdgeTuple(distance));
            path.add(root);
            distance++;
        } while(root != null);

        System.out.println(edges.size());
        
        return path;
        */
    }
    
    @Override
    public void PrintPath()
    {
        List<EdgeTuple> path = ReconstructPath();
        
        for(EdgeTuple edge : path)
        {
            if(edge != null)
            {
                System.out.println(edge.toString());
            }
        }
    }
    
    class EdgeCompare implements Comparator<EdgeTuple>
    {

        @Override
        public int compare(EdgeTuple a, EdgeTuple b)
        {
            return a.Distance - b.Distance;
        }
        
    }
}
