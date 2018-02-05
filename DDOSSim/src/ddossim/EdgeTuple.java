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
    
    public int Source;
    public int Start;
    public int End;
    public int Distance;
    
    public EdgeTuple(EdgePacket packet)
    {
        Source = packet.GetSrcAddress();
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
        return String.format("Src: %d; Edge: %d - %d; Distance: %d", Source, Start, End, Distance);
    }
}
