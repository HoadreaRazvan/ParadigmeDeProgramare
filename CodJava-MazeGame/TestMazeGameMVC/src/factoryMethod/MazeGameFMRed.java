package factoryMethod;

import maze.*;

public class MazeGameFMRed extends MazeGameFM {

    @Override
    public Room makeRoom(int roomNumber) {
        return new RoomRed(roomNumber);
    }

}
