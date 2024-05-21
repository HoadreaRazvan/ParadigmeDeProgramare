package factoryMethod;

import maze.Direction;
import maze.Door;
import maze.Maze;
import maze.Room;
import maze.Wall;


public class SimpleMazeGame {

    /**
     * @return Creates a large maze with 10 rooms.
     */
    public Maze createLargeMaze() {
        Maze maze = new Maze();
        Room room0 = new Room(0);
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        Room room4 = new Room(4);
        Room room5 = new Room(5);
        Room room6 = new Room(6);
        Room room7 = new Room(7);
        Room room8 = new Room(8);
        Room room9 = new Room(9);

        Door door0 = new Door(room0, room8);
        Door door1 = new Door(room1, room2);
        Door door2 = new Door(room2, room3);
        Door door3 = new Door(room4, room5);
        Door door4 = new Door(room5, room6);
        Door door5 = new Door(room5, room8);
        Door door6 = new Door(room6, room9);
        Door door7 = new Door(room7, room8);
        Door door8 = new Door(room1, room4);

        door1.setOpen(true);
        door2.setOpen(false);
        door3.setOpen(true);
        door4.setOpen(true);
        door5.setOpen(false);
        door6.setOpen(true);
        door7.setOpen(true);
        door8.setOpen(true);

        room1.setSide(Direction.North, door8);
        room1.setSide(Direction.East, new Wall());
        room1.setSide(Direction.South, new Wall());
        room1.setSide(Direction.West, door1);

        room2.setSide(Direction.North, new Wall());
        room2.setSide(Direction.East, door1);
        room2.setSide(Direction.South, new Wall());
        room2.setSide(Direction.West, door2);

        room3.setSide(Direction.North, new Wall());
        room3.setSide(Direction.East, door2);
        room3.setSide(Direction.South, new Wall());
        room3.setSide(Direction.West, new Wall());

        room4.setSide(Direction.North, new Wall());
        room4.setSide(Direction.East, new Wall());
        room4.setSide(Direction.South, door8);
        room4.setSide(Direction.West, door3);

        room5.setSide(Direction.North, door5);
        room5.setSide(Direction.East, door3);
        room5.setSide(Direction.South, new Wall());
        room5.setSide(Direction.West, door4);

        room6.setSide(Direction.North, door6);
        room6.setSide(Direction.East, door4);
        room6.setSide(Direction.South, new Wall());
        room6.setSide(Direction.West, new Wall());

        room7.setSide(Direction.North, new Wall());
        room7.setSide(Direction.East, new Wall());
        room7.setSide(Direction.South, new Wall());
        room7.setSide(Direction.West, door7);

        //room8.setSide(Direction.North, new Wall());
        room8.setSide(Direction.East, door7);
        room8.setSide(Direction.South, door5);
        room8.setSide(Direction.West, new Wall());
        room8.setSide(Direction.North, door0);

        room9.setSide(Direction.East, new Wall());
        room9.setSide(Direction.South, door6);
        room9.setSide(Direction.West, new Wall());
        room9.setSide(Direction.North, new Wall());

        room0.setSide(Direction.North, new Wall());
        room0.setSide(Direction.East, new Wall());
        room0.setSide(Direction.South, door0);
        room0.setSide(Direction.West, new Wall());

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

        maze.createGrid();
        /*
        //test GridView:
        Maze.GridView grid = maze.getGrid();
        System.out.println("Loc:" + grid.getLocations());
        System.out.println("Xmin=" + grid.getMinX());
        System.out.println("Xmax=" + grid.getMaxX());
        System.out.println("Ymin=" + grid.getMinY());
        System.out.println("Ymax=" + grid.getMaxY());
        */
        maze.setCurrentRoom(1);
        return maze;
    }

    /**
     *
     * @return Creates a small maze.
     */
    public Maze createMaze() {

        Maze maze = new Maze();
        Room room0 = new Room(0);
        Room room1 = new Room(1);
        Door door = new Door(room0, room1);
        door.setOpen(false);

        room0.setSide(Direction.North, new Wall());
        room0.setSide(Direction.East, door);
        room0.setSide(Direction.South, new Wall());
        room0.setSide(Direction.West, new Wall());

        room1.setSide(Direction.North, new Wall());
        room1.setSide(Direction.East, new Wall());
        room1.setSide(Direction.South, new Wall());
        room1.setSide(Direction.West, door);

        maze.addRoom(room0);
        maze.addRoom(room1);

        maze.setCurrentRoom(room1);
        maze.createGrid();
        return maze;
    }

    public Maze loadMaze(final String path) {
        Maze maze = new Maze();
        System.out.println("Please load a maze from the file!");
        return maze;
    }
}
