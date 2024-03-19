import java.util.Random;
public class PasswordMaker
{
    private static PasswordMaker instance= null;
    private final Integer MAGIC_NUMBER=10;
    private final String MAGIC_STRING;
    private int counter=0;

    private String password;
    private PasswordMaker(String name)
    {
        MAGIC_STRING=randomStringGenerator(20);
        String sir = randomStringGenerator(MAGIC_NUMBER);
        String sir1 = MAGIC_STRING_StringGenerator(10);
        int number=name.length();
        int number1 = (int)(Math.random()*50);

        this.password=sir+sir1+number+number1;
        counter++;

    }

    public static PasswordMaker getInstance(String name) {
        if (instance == null)
            instance = new PasswordMaker(name);
        return instance;
    }

    public String randomStringGenerator(int size)
    {
        String alphabet = new String("abcdefghijklmnopqrstuvwqyz");
        String newString = "";
        int number = (int)(Math.random()*alphabet.length());
        for(int i=0;i<number;i++)
            newString += alphabet.charAt((int) (Math.random() * alphabet.length()));
        return newString;
    }

    public String MAGIC_STRING_StringGenerator(int size)
    {
        String alphabet = new String(MAGIC_STRING);
        String newString = new String("");
        int number = (int)(Math.random()*alphabet.length());
        for(int i=0;i<number;i++)
            newString += alphabet.charAt((int) (Math.random() * alphabet.length()));
        return newString;
    }

    public String getPassword()
    {
        return this.password;
    }

    public int getCounter() {
        return counter;
    }
}
