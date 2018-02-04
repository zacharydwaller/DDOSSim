/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

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
    public void MarkPacket(IPacket packet, float markingProbability)
    {
        // let x be a random number [0..1)
        // if x < markingProbability
        //      write address into packet
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
