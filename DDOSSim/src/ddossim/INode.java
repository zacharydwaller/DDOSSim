/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public interface INode
{

    public int GetAddress();
    
    public boolean IsAttacker();

    public void SendPacket(IPacket packet);

    public void ReceivePacket(IPacket packet);
}
