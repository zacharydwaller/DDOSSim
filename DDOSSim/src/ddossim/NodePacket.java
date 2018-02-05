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
    private boolean isFromAttacker;

    public NodePacket(int src, int dest, boolean isFromAttacker)
    {
        srcAddress = src;
        destAddress = dest;
        this.isFromAttacker = isFromAttacker;
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
    
    @Override
    public boolean IsFromAttacker()
    {
        return isFromAttacker;
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
