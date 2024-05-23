package controller;

import maze.listeners.MazeMoveListener;
import maze.*;

/**
 *
 * @author admin
 */
public class MoveController implements MazeMoveListener {
    //ar fi interesant sa folosesc si Visitor ??
    Maze model;


    public MoveController(Maze maze) {
        this.model = maze;
    }

    @Override
    public void moveNorth(Maze maze) {
        move(maze.getCurrentRoom().getSide(Direction.North));
    }

    @Override
    public void moveSouth(Maze maze) {
        move(maze.getCurrentRoom().getSide(Direction.South));
    }

    @Override
    public void moveEast(Maze maze) {
        move(maze.getCurrentRoom().getSide(Direction.East));
    }

    @Override
    public void moveWest(Maze maze) {
        move(maze.getCurrentRoom().getSide(Direction.West));
    }

    private void move(MapSite toSite) {
        toSite.enter();

        if ((toSite instanceof Room)) {
            model.setCurrentRoom((Room) toSite);

        } else if ((toSite instanceof Door)) {
            model.setCurrentRoom(((Door) toSite).getOtherSide(model.getCurrentRoom()));
            model.getCurrentRoom().enter();
        }

    }

    @Override
    public void undoMove() {
        throw new UnsupportedOperationException("undoMove - Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
