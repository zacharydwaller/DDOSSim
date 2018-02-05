/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Zachary Waller
 */
public class NodeSampler implements ISampler
{

    // Key: Packet RR Address; Value: Count
    private HashMap<Integer, NodeTuple> nodeTable;

    public NodeSampler()
    {
        nodeTable = new HashMap();
    }

    @Override
    public void LogPacket(IPacket packet)
    {
        if(!packet.IsFromAttacker()) return;
        
        NodePacket nodePacket = (NodePacket) packet;
        int rr = nodePacket.GetRR();
        if (nodeTable.containsKey(rr))
        {
            NodeTuple tuple = nodeTable.get(rr);
            tuple.Count++;
            nodeTable.replace(rr, tuple);
        }
        else
        {
            nodeTable.put(rr, new NodeTuple(nodePacket.GetSrcAddress(), rr, 1));
        }
    }

    public List<NodeTuple> ReconstructPath()
    {
        List<NodeTuple> path = new ArrayList<>(nodeTable.values());
        Collections.sort(path, new CountCompare());

        return path;
    }

    class CountCompare implements Comparator<NodeTuple>
    {

        // Sorts in descending order by Count
        @Override
        public int compare(NodeTuple a, NodeTuple b)
        {
            return b.Count - a.Count;
        }
    }

}
