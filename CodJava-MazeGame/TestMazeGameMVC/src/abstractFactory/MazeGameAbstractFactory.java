package abstractFactory;

import maze.Direction;
import maze.Door;
import maze.Maze;
import maze.Room;


/*
 *   Abstract Factory design pattern
 *
 *  Metoda statica createLargeMaze(factory)  permite construirea Maze. 
 *  Variante diferite de Maze depind de ce factory este furnizat ca parametru  
 *  (vezi ClientAF.main(...))
 */
public class MazeGameAbstractFactory {

    public static Maze createLargeMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room room0 = factory.makeRoom(0);
        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Room room3 = factory.makeRoom(3);
        Room room4 = factory.makeRoom(4);
        Room room5 = factory.makeRoom(5);
        Room room6 = factory.makeRoom(6);
        Room room7 = factory.makeRoom(7);
        Room room8 = factory.makeRoom(8);
        Room room9 = factory.makeRoom(9);

        Door door0 = factory.makeDoor(room0, room8);
        Door door1 = factory.makeDoor(room1, room2);
        Door door2 = factory.makeDoor(room2, room3);
        Door door3 = factory.makeDoor(room4, room5);
        Door door4 = factory.makeDoor(room5, room6);
        Door door5 = factory.makeDoor(room5, room8);
        Door door6 = factory.makeDoor(room6, room9);
        Door door7 = factory.makeDoor(room7, room8);
        Door door8 = factory.makeDoor(room1, room4);

        door1.setOpen(true);
        door2.setOpen(false);
        door3.setOpen(true);
        door4.setOpen(true);
        door5.setOpen(false);
        door6.setOpen(true);
        door7.setOpen(true);
        door8.setOpen(true);

        room1.setSide(Direction.North, door8);
        room1.setSide(Direction.East, factory.makeWall());
        room1.setSide(Direction.South, factory.makeWall());
        room1.setSide(Direction.West, door1);

        room2.setSide(Direction.North, factory.makeWall());
        room2.setSide(Direction.East, door1);
        room2.setSide(Direction.South, factory.makeWall());
        room2.setSide(Direction.West, door2);

        room3.setSide(Direction.North, factory.makeWall());
        room3.setSide(Direction.East, door2);
        room3.setSide(Direction.South, factory.makeWall());
        room3.setSide(Direction.West, factory.makeWall());

        room4.setSide(Direction.North, factory.makeWall());
        room4.setSide(Direction.East, factory.makeWall());
        room4.setSide(Direction.South, door8);
        room4.setSide(Direction.West, door3);

        room5.setSide(Direction.North, door5);
        room5.setSide(Direction.East, door3);
        room5.setSide(Direction.South, factory.makeWall());
        room5.setSide(Direction.West, door4);

        room6.setSide(Direction.North, door6);
        room6.setSide(Direction.East, door4);
        room6.setSide(Direction.South, factory.makeWall());
        room6.setSide(Direction.West, factory.makeWall());

        room7.setSide(Direction.North, factory.makeWall());
        room7.setSide(Direction.East, factory.makeWall());
        room7.setSide(Direction.South, factory.makeWall());
        room7.setSide(Direction.West, door7);

        //room8.setSide(Direction.North, factory.makeWall());
        room8.setSide(Direction.East, door7);
        room8.setSide(Direction.South, door5);
        room8.setSide(Direction.West, factory.makeWall());
        room8.setSide(Direction.North, door0);

        room9.setSide(Direction.East, factory.makeWall());
        room9.setSide(Direction.South, door6);
        room9.setSide(Direction.West, factory.makeWall());
        room9.setSide(Direction.North, factory.makeWall());

        room0.setSide(Direction.North, factory.makeWall());
        room0.setSide(Direction.East, factory.makeWall());
        room0.setSide(Direction.South, door0);
        room0.setSide(Direction.West, factory.makeWall());

        maze.addRoom(room0);
        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        maze.addRoom(room9);

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

}
