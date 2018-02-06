/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class Client implements INode
{
    private int address;
    private int victimAddress;
    private boolean isAttacker;
    private Router connectedRouter;
    
    
    public Client(int address, Router connectedRouter, boolean isAttacker)
    {
        this.address = address;
        this.connectedRouter = connectedRouter;
        this.isAttacker = isAttacker;
        victimAddress = SimMgr.GetInstance().GetVictimAddress();
    }

    public void Update()
    {
        int packetsToSend = 1;
        
        if(isAttacker)
        {
            packetsToSend *= SimMgr.GetInstance().GetAttackMultiplier();
        }
        
        for(int i = 0; i < packetsToSend; i++)
        {
            connectedRouter.ReceivePacket(CreatePacket());
        }
    }
    
    @Override
    public int GetAddress()
    {
        return address;
    }

    @Override
    public boolean IsAttacker()
    {
        return isAttacker;
    }

    @Override
    public void SendPacket(IPacket packet)
    {
        connectedRouter.ReceivePacket(packet);
    }

    @Override
    public void ReceivePacket(IPacket packet)
    {
        // Will never receive packet
    }
    
    @Override
    public String toString()
    {
        String str = "";
        if(isAttacker)
        {
            str += "Attacker";
        }
        else
        {
            str += "Client";
        }
        
        return str + String.format(", Addr: %d, Connected Router: %d", address, connectedRouter.GetAddress());
    }
    
    private IPacket CreatePacket()
    {
        AlgorithmType type = SimMgr.GetInstance().GetAlgorithm();
        if(type == AlgorithmType.NodeSampling)
        {
            return new NodePacket(address, victimAddress);
        }
        else
        {
            return new EdgePacket(address, victimAddress);
        }
    }
    
}
