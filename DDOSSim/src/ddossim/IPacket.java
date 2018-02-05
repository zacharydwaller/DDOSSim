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
    
    public int GetSrcAddress();
    
    public int GetDestAddress();

    // Assuming attack detection is flagging suspicious packets
    public boolean IsFromAttacker();
    
}
