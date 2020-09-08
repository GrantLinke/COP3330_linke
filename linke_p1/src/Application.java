//Grant Linke COP3330 Fall2020
public class Application
{
    public static void main(String[] args)
    {
        Encrypter enc = new Encrypter();
        System.out.println(enc.encrypt("1234"));
        Decrypter dec = new Decrypter();
        System.out.println(dec.decrypt(enc.encrypt("1234")));
    }
}
