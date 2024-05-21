
package abstractFactory;
import maze.*;
/**
 *
 * @author dorin
 */
public class RedFactory extends MazeFactory{
    @Override
    public Room makeRoom(int n){
        return new RoomRed(n);
    }
}
