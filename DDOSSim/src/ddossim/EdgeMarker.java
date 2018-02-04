/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

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
        // let x be a random number [0..1)
        // if x < p 
        //      write address into packet.start
        //      write 0 into packet.distance
        // else
        //      if packet.distance == 0
        //          write address into packet.end
        //      increment packet.distance
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
