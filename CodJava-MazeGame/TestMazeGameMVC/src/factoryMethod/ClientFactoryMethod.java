package factoryMethod;

import java.awt.Point;
import java.util.Map;
import maze.Maze;
import maze.Room;

import controller.MoveController;
import view.GuiMaze;
import view.TextUiMaze;

/**
 *
 * @author dorin
 */
public class ClientFactoryMethod {

    public static void main(String[] args) {
        //Testare una dintre cele 3 variante
        //decomentează una dintre variante:

        //1. Hard-codare !! )-:
        //SimpleMazeGame game = new SimpleMazeGame();
        //2. Varianta FactoryMethod=>flexibilitate
        MazeGameFM game = new MazeGameFM();
        //3. Extensie simpla varianta 2 : RoomRed
        //MazeGameFM game = new MazeGameFMRed();

        Maze maze = game.createLargeMaze();
        maze.setCurrentRoom(0);
        /*
        //start test: daca  am omis hashCode() ----
        Maze.GridView grid = maze.getGrid();
        Map<Room, Point> l = grid.getLocations();
        System.out.println("Grid.size=" + l.size());
        System.out.println("Pos(R0);" + l.get(new Room(0)));
        System.out.println("R(0).hashCode=" + maze.getRoom(0).hashCode());
        Room tmp0 = new Room(0);
        System.out.println("R(0).hashCode=" + tmp0.hashCode());
        //end test----------------------
         */

        //Interfata grafica: GUI(swing)
        GuiMaze viewer = new GuiMaze(maze, new MoveController(maze));
        viewer.run();
        
        //Interfata cu utilizatorul: consola
        TextUiMaze textViewer;
        textViewer = new TextUiMaze(maze, new controller.MoveController(maze));
 
        maze.getCurrentRoom().enter();
        textViewer.run();

    }
}
