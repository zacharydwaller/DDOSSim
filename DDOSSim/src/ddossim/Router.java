/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zachary Waller
 */
public class Router implements INode
{

    private int address;
    private INode parent;
    private IMarker marker;
    private float markingProbability;
    
    private List<INode> children;
    
    public Router(int address, INode parent)
    {
        this.address = address;
        this.parent = parent;
        markingProbability = SimMgr.GetInstance().GetMarkingProbability();
        children = new ArrayList<INode>();
        
        AlgorithmType alg = SimMgr.GetInstance().GetAlgorithm();
        if(alg == AlgorithmType.NodeSampling)
        {
            marker = new NodeMarker(address);
        }
        else
        {
            marker = new EdgeMarker(address);
        }
    }
    
    public void AddChild(INode child)
    {
        children.add(child);
    }
    
    public boolean HasChildren()
    {
        return !children.isEmpty();
    }
    
    @Override
    public int GetAddress()
    {
        return address;
    }

    @Override
    public boolean IsAttacker()
    {
        return false;
    }

    @Override
    public void SendPacket(IPacket packet)
    {
        parent.ReceivePacket(packet);
    }

    @Override
    public void ReceivePacket(IPacket packet)
    {
        marker.ProcessPacket(packet, markingProbability);
        SendPacket(packet);
    }
    
    @Override
    public String toString()
    {
        String str = "Router, Addr: " + address + ", Parent: " + parent.GetAddress();
        
        if(HasChildren())
        {
            str += ", Children:";
            for(INode node : children)
            {
                str += " " + node.GetAddress();
            }
        }
        str += ";";
        
        return str;
    }
    
}
