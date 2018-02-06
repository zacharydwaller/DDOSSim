/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

/**
 *
 * @author Zachary Waller
 */
public interface IMarker
{
    public void ProcessPacket(IPacket packet, float markingProbability);
}
