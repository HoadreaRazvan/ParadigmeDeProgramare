/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

import controller.MoveController;
import maze.Maze;
import view.GuiMaze;
import view.TextUiMaze;

/**
 *
 * @author dorin
 */
public class ClientAF {

    public static void main(String[] args) {
        String varianta;
        varianta = "default";
        //varianta= "red";

        MazeFactory factory = varianta.equals("default")
                ? new MazeFactory()
                : new RedFactory();

        Maze maze;
        maze = MazeGameAbstractFactory.createLargeMaze(factory);
        maze.setCurrentRoom(5);
        //Interfata grafica: GUI(swing)
        GuiMaze viewer = new GuiMaze(maze, new MoveController(maze));

        //Interfata cu utilizatorul: consola
        TextUiMaze textViewer;
        viewer.run();

        textViewer = new TextUiMaze(maze, new controller.MoveController(maze));
        textViewer.run();

        maze.getCurrentRoom().enter();

    }
}
