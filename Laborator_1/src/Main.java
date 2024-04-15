import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LitereAlfabet litereAlfabet = new LitereAlfabet();

        litereAlfabet.litereMici();
        System.out.println();
        litereAlfabet.litereMari();


        String text = new String("abcdefghijklmnopqrstuvwxyz");
        ArrayList<String> lista[] = new ArrayList[100];
        Integer k = 0;
        String vocale = new String("aeiou");
        for (int i = 0; i < text.length(); i++) {
            if (vocale.contains("" + text.charAt(i)) && i != 0) {
                if (lista[++k] == null)
                    lista[k] = new ArrayList<>();
                lista[k].add("" + text.charAt(i));
            } else {
                if (lista[k] == null)
                    lista[k] = new ArrayList<>();
                lista[k].add("" + text.charAt(i));
            }
        }

        for (int i = 0; i < k; i++) {
            for (String caracter : lista[i])
                System.out.println(caracter + " ");
            System.out.println();
        }


        //c
        int[] numere = {12, 3, 500, 1200, 50, 40, 100, 250, 8};
        int sizeMax=String.valueOf(numere[0]).length();
        for(int i=1;i<numere.length;i++)
            if (sizeMax < String.valueOf(numere[i]).length())
                sizeMax=String.valueOf(numere[i]).length();

        for(int i=0;i<numere.length;i++)
        {
            if(i%3==0 && i!=0) System.out.println();
            for(int j=sizeMax;j>String.valueOf(numere[i]).length();j--)
                System.out.print(" ");
            System.out.print(numere[i]+"  ");
        }

    }
}