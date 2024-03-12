import java.util.ArrayList;

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


    }
}