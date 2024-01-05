import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static int mujHash(String str){
        int out = 0;
        for(char ch: str.toCharArray()) out += (int)ch;
        out %= 13;

        return out;
    }


    static String[] poleSlov = new String[13];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            String vstup = sc.next();
            int hashSlova = mujHash(vstup);

            ulozCislo(hashSlova, vstup);
        }
    }

    private static void ulozCislo(int c, String s) {
        if(obsahujePolePrvek(poleSlov, s)){
            System.out.println("Pole uz slovo obsahuje");
        }
        else{
            poleSlov[c] = s;
            System.out.println("Hash slova: " + c);
        }
    }

    private static boolean obsahujePolePrvek(String[] pole, String prvek){

        boolean out = false;
        for (String p: pole) {
            if(Objects.equals(p, prvek)){
                out = true;
                break;
            }
        }

        return out;
    }

}