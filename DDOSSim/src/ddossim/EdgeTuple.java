/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class EdgeTuple implements ITuple
{
    
    public int Start;
    public int End;
    public int Distance;
    
    public EdgeTuple(int start, int end, int distance)
    {
        Start = start;
        End = end;
        Distance = distance;
    }
    
}
