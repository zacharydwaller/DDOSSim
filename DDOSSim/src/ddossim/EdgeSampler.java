/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Zachary Waller
 */
public class EdgeSampler implements ISampler
{

    private TreeSet<EdgeTuple> edgeTree;
    private int rootAddress;
    
    public EdgeSampler(int rootAddress)
    {
        this.rootAddress = rootAddress;
        edgeTree = new TreeSet<>(new EdgeCompare());
    }
    
    @Override
    public void LogPacket(IPacket packet)
    {
        if(!packet.IsFromAttacker()) return;
        
        EdgePacket edgePacket = (EdgePacket) packet;
        if(edgePacket.GetDistance() == 0)
        {
            edgePacket.SetEdgeEnd(rootAddress);
            edgeTree.add(new EdgeTuple(edgePacket));
        }
        else
        {
            edgeTree.add(new EdgeTuple(edgePacket));
        }
    }
    
    public List<EdgeTuple> ReconstructPath()
    {
        List<EdgeTuple> path = new ArrayList<>();
        int distance = -1;
        
        EdgeTuple root = null;
        do
        {
            root = edgeTree.higher(new EdgeTuple(distance));
            path.add(root);
            distance++;
        } while(root != null);

        System.out.println(edgeTree.size());
        
        return path;
    }
    
    class EdgeCompare implements Comparator<EdgeTuple>
    {

        // Sort by end and then start nodes
        @Override
        public int compare(EdgeTuple a, EdgeTuple b)
        {
            return a.Distance - b.Distance;
        }
    }
}
