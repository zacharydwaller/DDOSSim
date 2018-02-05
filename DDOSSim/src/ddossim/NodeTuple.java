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
    
    public int Source;
    public int Node;
    public int Count;
    
    public NodeTuple(int source, int node, int count)
    {
        Source = source;
        Node = node;
        Count = count;
    }
    
    @Override
    public String toString()
    {
        return String.format("Src: %d; Node: %d; Count: %d", Source, Node, Count);
    }
}
