/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class NodeTuple implements ITuple
{
    
    public int Address;
    public int Count;
    
    public NodeTuple(int address, int count)
    {
        Address = address;
        Count = count;
    }
    
}
