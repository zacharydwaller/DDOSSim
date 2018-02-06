/*
 * Author: Zachary Waller
 * CS 445 - Spring 2018
 */
package ddossim;

import java.util.List;

/**
 *
 * @author Zachary Waller
 */
public interface ISampler
{

    public void LogPacket(IPacket packet);

    public void PrintPath();
    
}
