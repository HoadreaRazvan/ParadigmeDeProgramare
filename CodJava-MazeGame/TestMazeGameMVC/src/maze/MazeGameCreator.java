package maze;

import controller.MoveController;
import view.GuiMaze;

/*
 *  Build a Maze game. 
 *
 *  This design uses Factory Methods design pattern. 
 *
 *  Compare this design with the one using Abstract Factory design pattern:
 *    MazeGameAbstractFactory   
 *
 */
public class MazeGameCreator {

    /**
     * Creates a large maze with 10 rooms.
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
        //test:
        Maze.GridView grid = maze.getGrid();
        System.out.println("Loc:" + grid.getLocations());
        System.out.println("Xmin=" + grid.getMinX());
        System.out.println("Xmax=" + grid.getMaxX());
        System.out.println("Ymin=" + grid.getMinY());
        System.out.println("Ymax=" + grid.getMaxY());

        return maze;
    }

    // This method must not be static
    public Maze createMaze() {
        Maze maze = makeMaze();
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

        Door door0 = makeDoor(room0, room1);
        Door door1 = makeDoor(room1, room2);
        Door door2 = makeDoor(room2, room3);
        Door door3 = makeDoor(room4, room5);
        Door door4 = makeDoor(room5, room6);
        Door door5 = makeDoor(room5, room8);
        Door door6 = makeDoor(room6, room9);
        Door door7 = makeDoor(room7, room8);
        Door door8 = makeDoor(room1, room4);

        door0.setOpen(true);
        door1.setOpen(true);
        door2.setOpen(false);
        door3.setOpen(true);
        door4.setOpen(true);
        door5.setOpen(false);
        door6.setOpen(true);
        door7.setOpen(true);
        door8.setOpen(true);

        room0.setSide(Direction.North, makeWall());
        room0.setSide(Direction.East, makeWall());
        room0.setSide(Direction.South, makeWall());
        room0.setSide(Direction.West, door0);

        room1.setSide(Direction.North, door8);
        room1.setSide(Direction.East, door0);
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

        room8.setSide(Direction.North, makeWall());
        room8.setSide(Direction.East, door7);
        room8.setSide(Direction.South, door5);
        room8.setSide(Direction.West, makeWall());

        room9.setSide(Direction.North, makeWall());
        room9.setSide(Direction.East, makeWall());
        room9.setSide(Direction.South, door6);
        room9.setSide(Direction.West, makeWall());
        
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

    public static void main(String[] args) {
        Maze maze;
        MazeGameCreator creator = null;

        if (args.length > 0) {
            if ("Harry".equals(args[0])) {
                //creator = new maze.v1.V1MazeGameCreator(); 
            } else if ("Snow".equals(args[0])) {
                //creator = new maze.snow.SnowWhiteMazeGameCreator(); 
            }
        }
        if (creator == null) {
            creator = new MazeGameCreator();
        }
        maze = creator.createMaze();
        //maze=creator.createLargeMaze();
        maze.setCurrentRoom(0);
        GuiMaze viewer = new GuiMaze(maze, new MoveController(maze));
        viewer.run();

        //maze.showFrame("Maze -- Factory Method");
    }

}
