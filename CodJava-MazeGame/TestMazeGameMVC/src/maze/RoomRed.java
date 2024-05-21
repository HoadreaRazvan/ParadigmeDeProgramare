/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.awt.Color;

/**
 *
 * @author dorin
 */
public class RoomRed extends Room{
    
    public RoomRed(int num) {
        super(num);
    }
        @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public String toString() {
        return "RoomRed{" + '}';
    }
    
}
