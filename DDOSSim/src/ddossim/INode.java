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

    public void GetAddress();

    public void SendPacket(IPacket packet);

    public void ReceivePacket(IPacket packet);
}
