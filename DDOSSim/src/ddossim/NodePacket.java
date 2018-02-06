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

    private int srcAddress;
    private int destAddress;
    private int rrAddress;

    public NodePacket(int src, int dest)
    {
        srcAddress = src;
        destAddress = dest;
    }
    
    @Override
    public int GetSrcAddress()
    {
        return srcAddress;
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
