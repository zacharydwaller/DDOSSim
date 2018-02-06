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
public class NodeMarker implements IMarker
{

    private int address;
    
    public NodeMarker(int newAddress)
    {
        address = newAddress;
    }
    
    @Override
    public void ProcessPacket(IPacket packet, float markingProbability)
    {
        Random rand = new Random();
        
        float x = rand.nextFloat();
        if(x < markingProbability)
        {
            NodePacket nodePacket = (NodePacket) packet;
            nodePacket.SetRR(address);
        }
    }
    
}
