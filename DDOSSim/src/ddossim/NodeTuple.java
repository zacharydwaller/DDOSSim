/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class NodeTuple
{
    
    public int Node;
    public int Count;
    
    public NodeTuple(int node, int count)
    {
        Node = node;
        Count = count;
    }
    
    @Override
    public String toString()
    {
        return String.format("Node: %d; Count: %d", Node, Count);
    }
}
