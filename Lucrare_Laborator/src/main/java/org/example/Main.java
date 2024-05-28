package org.example;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ControlCredit controlCredit = new ControlCredit();

        controlCredit.citireFisier();

        controlCredit.afisare();

        System.out.println("1.");
        //controlCredit.cautareData("13.05.2024");
        controlCredit.cautareDescriere("abonament");

        System.out.println("2.");
        controlCredit.cautareSume(40);

        System.out.println("3.");
        controlCredit.adaugareOperatie("11.05.2024 parcare_rasinari_120  120");


        System.out.println("4.");
        controlCredit.afisare();
    }
}