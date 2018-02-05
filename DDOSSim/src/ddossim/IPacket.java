/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public interface IPacket
{
    
    // Not keeping track of SrcAddress because assuming attacker spoofed it
    
    public int GetDestAddress();

}
