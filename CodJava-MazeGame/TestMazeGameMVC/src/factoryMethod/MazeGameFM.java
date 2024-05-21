
package factoryMethod;

import maze.Direction;
import maze.Door;
import maze.Maze;
import maze.Room;
import maze.Wall;

/**
 *     Utilizam varianta cu Factory Method
 * Clasa "Creator"(vezi Gamma): introduce si ofera implementarea 'default' 
 * pentru metodele factory(makeMaze(), makeRoom(),...) care produc produsele 
 * implicite(Maze, Room,...)
 * Metoda createLargeMaze() ('AnOperation()' in cartea lui Gamma) utilizeaza
 * metodele factory pentru a oferi flexibilitate: ascund constructorii folositi,
 * lasand posibilitatea claselor descendente sa creeze produse diferite
 */
public class MazeGameFM {
    public Maze createLargeMaze() {
        Maze maze =  makeMaze();
        Room room0 = makeRoom(0);
        Room room1 = makeRoom(1);
        Room room2 = makeRoom(2);
        Room room3 = makeRoom(3);
        Room room4 = makeRoom(4);
        Room room5 = makeRoom(5);
        Room room6 = makeRoom(6);
        Room room7 = makeRoom(7);
        Room room8 = makeRoom(8);
        Room room9 = makeRoom(9);

        Door door0 = makeDoor(room0, room8);
        Door door1 = makeDoor(room1, room2);
        Door door2 = makeDoor(room2, room3);
        Door door3 = makeDoor(room4, room5);
        Door door4 = makeDoor(room5, room6);
        Door door5 = makeDoor(room5, room8);
        Door door6 = makeDoor(room6, room9);
        Door door7 = makeDoor(room7, room8);
        Door door8 = makeDoor(room1, room4);

        door1.setOpen(true);
        door2.setOpen(false);
        door3.setOpen(true);
        door4.setOpen(true);
        door5.setOpen(false);
        door6.setOpen(true);
        door7.setOpen(true);
        door8.setOpen(true);

        room1.setSide(Direction.North, door8);
        room1.setSide(Direction.East, makeWall());
        room1.setSide(Direction.South, makeWall());
        room1.setSide(Direction.West, door1);

        room2.setSide(Direction.North, makeWall());
        room2.setSide(Direction.East, door1);
        room2.setSide(Direction.South, makeWall());
        room2.setSide(Direction.West, door2);

        room3.setSide(Direction.North, makeWall());
        room3.setSide(Direction.East, door2);
        room3.setSide(Direction.South, makeWall());
        room3.setSide(Direction.West, makeWall());

        room4.setSide(Direction.North, makeWall());
        room4.setSide(Direction.East, makeWall());
        room4.setSide(Direction.South, door8);
        room4.setSide(Direction.West, door3);

        room5.setSide(Direction.North, door5);
        room5.setSide(Direction.East, door3);
        room5.setSide(Direction.South, makeWall());
        room5.setSide(Direction.West, door4);

        room6.setSide(Direction.North, door6);
        room6.setSide(Direction.East, door4);
        room6.setSide(Direction.South, makeWall());
        room6.setSide(Direction.West, makeWall());

        room7.setSide(Direction.North, makeWall());
        room7.setSide(Direction.East, makeWall());
        room7.setSide(Direction.South, makeWall());
        room7.setSide(Direction.West, door7);

        //room8.setSide(Direction.North, makeWall());
        room8.setSide(Direction.East, door7);
        room8.setSide(Direction.South, door5);
        room8.setSide(Direction.West, makeWall());
        room8.setSide(Direction.North, door0);

        room9.setSide(Direction.East, makeWall());
        room9.setSide(Direction.South, door6);
        room9.setSide(Direction.West, makeWall());
        room9.setSide(Direction.North, makeWall());

        room0.setSide(Direction.North, makeWall());
        room0.setSide(Direction.East, makeWall());
        room0.setSide(Direction.South, door0);
        room0.setSide(Direction.West, makeWall());

        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        maze.addRoom(room9);
        maze.addRoom(room0);
        
        maze.setCurrentRoom(1);
        maze.createGrid();
        //test:
        Maze.GridView grid = maze.getGrid();
        System.out.println("Loc:" + grid.getLocations());
        System.out.println("Xmin=" + grid.getMinX());
        System.out.println("Xmax=" + grid.getMaxX());
        System.out.println("Ymin=" + grid.getMinY());
        System.out.println("Ymax=" + grid.getMaxY());

        return maze;
    }

    public Maze makeMaze() {
    return new Maze(); 
  }

  public Wall makeWall() { 
    return new Wall(); 
  }

  public Room makeRoom(int roomNumber) { 
    return new Room(roomNumber); 
  }

  public Door makeDoor(Room room1, Room room2) { 
    return new Door(room1, room2); 
  }
}
