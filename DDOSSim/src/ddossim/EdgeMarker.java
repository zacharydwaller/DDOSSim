/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.Random;

/**
 *
 * @author Zachary Waller
 */
public class EdgeMarker implements IMarker
{

    private int address;
    
    public EdgeMarker(int newAddress)
    {
        address = newAddress;
    }
    
    @Override
    public void MarkPacket(IPacket packet, float markingProbability)
    {
        Random rand = new Random();
        EdgePacket edgePacket = (EdgePacket) packet;
        
        float x = rand.nextFloat();
        if(x < markingProbability)
        {
            edgePacket.SetEdgeStart(address);
            edgePacket.ZeroDistance();
        }
        else
        {
            if(edgePacket.GetDistance() == 0)
            {
                edgePacket.SetEdgeEnd(address);
            }
            edgePacket.IncrementDistance();
        }
    }
    
}
