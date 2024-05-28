package org.example;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ControlCredit {

    private ArrayList<Credit> listaCredit ;

    public ControlCredit()
    {
        listaCredit = new ArrayList<Credit>();
    }

    public void citireFisier()
    {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("in.txt");
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(fis);
        String str = null;
        try{
            int k=0;
            while((str = dis.readLine()) != null) {
                if(k!=0 && k!=1) {//ignor primele 2 linii
                    str = str.replaceAll("\\s+", " ");
                    if(str.split(" ")[1].equals("rulaj_total_cont")==false && str.split(" ")[1].equals("sold_final_cont")==false) //ultimele 2
                        if (str.split(" ").length == 3)
                            listaCredit.add(new Credit(str.split(" ")[0], str.split(" ")[1], str.split(" ")[2], "-"));
                        else
                            listaCredit.add(new Credit(str.split(" ")[0], str.split(" ")[1], str.split(" ")[2], str.split(" ")[3]));
                }
                k++;
            }
            dis.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }


    public void afisare()
    {
        for(Credit c : listaCredit)
            System.out.printf(c.toString()+"\n\n");
    }


    public ArrayList<Credit> cautareData(String data)
    {
        ArrayList<Credit> cautare = new ArrayList<Credit>();
        for(Credit c : listaCredit)
            if(c.getData().equals(data)==true){
                System.out.println(c.toString());    cautare.add(c); }
        return cautare;
    }

    public ArrayList<Credit> cautareDescriere(String descriere)
    {
        ArrayList<Credit> cautare = new ArrayList<Credit>();
        for(Credit c : listaCredit)
            if(c.getDescriere().split("_")[0].equals(descriere)==true){
                System.out.println(c.toString()); cautare.add(c); }
        return cautare;
    }

    public ArrayList<Credit> cautareSume(int sume)
    {
        ArrayList<Credit> cautare = new ArrayList<Credit>();
        for(Credit c : listaCredit)
            if(c.getDebit().equals(String.valueOf(sume))==true || c.getCredit().equals(String.valueOf(sume))==true){
                System.out.println(c.toString());cautare.add(c); }
        return cautare;
    }

    public void adaugareOperatie(String linie)
    {
        linie = linie.replaceAll("\\s+", " ");
        if(linie.split(" ").length!=3)
        listaCredit.add(new Credit(linie.split(" ")[0],linie.split(" ")[1],linie.split(" ")[2],linie.split(" ")[3]));
        else
        listaCredit.add(new Credit(linie.split(" ")[0],linie.split(" ")[1],linie.split(" ")[2],"-"));
    }

}
