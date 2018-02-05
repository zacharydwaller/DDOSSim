/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class NodePacket implements IPacket
{

    private int destAddress;
    private int rrAddress;

    public NodePacket(int dest)
    {
        destAddress = dest;
    }
    
    @Override
    public int GetDestAddress()
    {
        return destAddress;
    }

    public void SetRR(int address)
    {
        rrAddress = address;
    }

    public int GetRR()
    {
        return rrAddress;
    }
}
