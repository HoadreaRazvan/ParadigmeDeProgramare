import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Agenda> listaAgende = new ArrayList<Agenda>();

        FileInputStream fis = null;
        try{
            fis = new FileInputStream("input_tema.txt");
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(fis);
        String str = null;
        try{
            while((str = dis.readLine()) != null) {
                listaAgende.add(new Agenda(str.split(" ")[0],str.split(" ")[1],str.split(" ")[2],str.split(" ")[3]));
            }
            dis.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }


        try {
            FileWriter writer = new FileWriter("output_tema.txt");

            //Collections.sort(listaAgende, Comparator.comparing(Agenda::getNume).thenComparing(Agenda::getPrenume).thenComparing(Agenda::getTipNrTelefon));

            Collections.sort(listaAgende, new Comparator<Agenda>() {
                @Override
                public int compare(Agenda o1, Agenda o2) {
                    if(o1.getNume().compareTo(o2.getNume())!=0)
                        return o1.getNume().compareTo(o2.getNume());
                    else if(o1.getPrenume().compareTo(o2.getPrenume())!=0)
                        return o1.getPrenume().compareTo(o2.getPrenume());
                    else if(o1.getTipNrTelefon().compareTo(o2.getTipNrTelefon())!=0)
                        return o1.getTipNrTelefon().compareTo(o2.getTipNrTelefon());
                    return 0;
                }
            });
            for(Agenda agenda : listaAgende)
            writer.write(agenda.getNume()+" "+agenda.getPrenume()+" "+agenda.getNrTelefon()+" "+agenda.getTipNrTelefon()+"\n");



            writer.write("\n\n");
            Map<String, Integer> contorAtribute = new HashMap<>();
            for(Agenda agenda : listaAgende)
                contorAtribute.put(agenda.getNrTelefon(), contorAtribute.getOrDefault(agenda.getNrTelefon(), 0) + 1);

            for(Agenda agenda : listaAgende) {
                writer.write(agenda.getNume() + " " + agenda.getPrenume() + " " + agenda.getNrTelefon() + " " + agenda.getTipNrTelefon());
                if(contorAtribute.get(agenda.getNrTelefon())!=1)
                    writer.write(" *\n");
                else
                    writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}