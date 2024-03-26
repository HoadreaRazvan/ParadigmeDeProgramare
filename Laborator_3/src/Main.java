import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(PasswordMaker.getInstance("Razvan").getPassword());
        System.out.println(PasswordMaker.getInstance("Razvan").getPassword());
        System.out.println(PasswordMaker.getInstance("Razvan").getPassword());

        System.out.println(PasswordMaker.getInstance("Razvan").getCounter());
    }
}