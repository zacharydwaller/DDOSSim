/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class EdgePacket implements IPacket
{

    private int destAddress;
    private int edgeStartAddress;
    private int edgeEndAddress;
    private int distance;

    public EdgePacket(int dest)
    {
        destAddress = dest;
        distance = 0;
    }
    
    @Override
    public int GetDestAddress()
    {
        return destAddress;
    }
    
    public int GetEdgeStart()
    {
        return edgeStartAddress;
    }

    public int GetEdgeEnd()
    {
        return edgeEndAddress;
    }

    public int GetDistance()
    {
        return distance;
    }

    public void SetEdgeStart(int edgeStartAddr)
    {
        this.edgeStartAddress = edgeStartAddr;
    }

    public void SetEdgeEnd(int edgeEndAddr)
    {
        this.edgeEndAddress = edgeEndAddr;
    }

    public void IncrementDistance()
    {
        distance++;
    }
    
    public void ZeroDistance()
    {
        distance = 0;
    }
}
