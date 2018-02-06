/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public class Server implements INode
{

    private int address;
    private AlgorithmType samplerType;
    private ISampler sampler;
    
    private long packetCount;
    
    private int cycle;
    
    public Server(int address, AlgorithmType samplerType)
    {
        this.address = address;
        this.samplerType = samplerType;
        
        packetCount = 0;
        cycle = 0;
        
        if(samplerType == AlgorithmType.NodeSampling)
        {
            sampler = new NodeSampler();
        }
        else
        {
            sampler = new EdgeSampler(address);
        }
    }
    
    public void Update()
    {
        System.out.println("Cycle " + cycle + ". Current Statistics:");
        sampler.PrintPath();
        System.out.println(String.format("\nTotal Packets: %d\n\n", packetCount));
        
        cycle++;
    }
    
    @Override
    public int GetAddress()
    {
        return address;
    }

    @Override
    public boolean IsAttacker()
    {
        return false;
    }

    @Override
    public void SendPacket(IPacket packet)
    {
        // Will never send a packet
    }

    @Override
    public void ReceivePacket(IPacket packet)
    {
        packetCount++;
        sampler.LogPacket(packet);
    }
    
}
