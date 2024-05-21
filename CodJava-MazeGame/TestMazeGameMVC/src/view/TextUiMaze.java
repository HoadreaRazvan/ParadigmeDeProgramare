/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MoveController;
import java.util.Scanner;
//import javax.swing.JOptionPane;
import maze.listeners.EntryListener;
import maze.MapSite;
import maze.Maze;
import maze.Room;

/**
 *
 * @author admin
 * 
 */
public class TextUiMaze implements EntryListener {

    Maze model;
    MoveController ctrl;

    public TextUiMaze(Maze model, MoveController ctrl) {
        this.model = model;
        this.ctrl = ctrl;
// merge si asa
//        for (Iterator<Room> iterator = model.iterator(); iterator.hasNext();) {
//            Room r = iterator.next();
//            r.addEntryListener(this);
//        } 

        for (Room r : model) {
            r.addEntryListener(this);
        }
    }

    @Override
    public void entered(MapSite ms) {
        //err doar sa apara textul rosu in consola
        System.err.println("----->>" + ms.toString());
    }

    //@Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("a,s,w sau z:");
                String line = sc.nextLine();
                if (line.isEmpty()){
                    break;
                }
                char c = line.charAt(0);

                switch (c) {
                    case 'a':
                        ctrl.moveWest(model);
                        break;
                    case 's':
                        ctrl.moveEast(model);
                        break;
                    case 'w':
                        ctrl.moveNorth(model);
                        break;
                    case 'z':
                        ctrl.moveSouth(model);
                        break;

                    default:                        
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
