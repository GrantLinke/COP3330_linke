//Grant Linke COP3330 Fall2020
import java.util.Scanner;
public class Application
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Encrypter enc = new Encrypter();
        Decrypter dec = new Decrypter();

        System.out.print("Numbers: ");
        String s1 = input.nextLine();
        String encrypted = enc.encrypt(s1);
        System.out.println(encrypted);
        System.out.println(dec.decrypt(encrypted));

    }
}
