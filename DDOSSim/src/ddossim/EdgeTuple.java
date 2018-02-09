/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class EdgeTuple
{
    
    public int Start;
    public int End;
    public int Distance;
    
    public EdgeTuple(EdgePacket packet)
    {
        Start = packet.GetEdgeStart();
        End = packet.GetEdgeEnd();
        Distance = packet.GetDistance();
    }
    
    // Creates a dummy tuple strictly for grabbing values out of a TreeSet
    public EdgeTuple(int key)
    {
        Distance = key;
    }
    
    @Override
    public String toString()
    {
        return String.format("Edge: %d - %d; Distance: %d", Start, End, Distance);
    }
    
    @Override
    public int hashCode()
    {
        return (Start * 1000) + End;
    }
}
