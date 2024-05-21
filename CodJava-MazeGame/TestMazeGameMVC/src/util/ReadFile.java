package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReadFile {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            String line;

            br = new BufferedReader(new FileReader("small.maze"));
            int i = 0;
            while ((line = br.readLine()) != null) {
                String sl[] = line.split("\\s");
                System.out.println(sl[0]+"  lg="+sl.length);
                String[] params = Arrays.copyOfRange(sl, 2, sl.length);
                System.out.println("PARAMS="+params);
                //System.out.println("");
                //line +="\n";
                //System.out.println((++i)+":"+line +"<<END>>");

                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");

                while (stringTokenizer.hasMoreElements()) {
                    System.out.print(stringTokenizer.nextToken()+".");

//                    Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
//                    Double price = Double.parseDouble(stringTokenizer.nextElement().toString());
//                    String username = stringTokenizer.nextElement().toString();
//
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("\nId : " + id); 
//                    sb.append("\nPrice : " + price);
//                    sb.append("\nUsername : " + username);
//                    sb.append("\n*******************\n");
//
//                    System.out.println(sb.toString());
                }
                System.out.println("");
            }

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}