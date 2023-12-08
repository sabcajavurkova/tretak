import java.util.Scanner;

public class Main {
        static int kolikPismenko(long x){
            return (int) ((x * (x +3)) % 1013);
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            String vstup = sc.nextLine();
            long sum = 0;

            for (char ch: vstup.toCharArray()) {
                sum += (int) ch;
            }

            vytiskni(vstup, (int) sum);
        }
    }

    private static void vytiskni(String zprava, int vysledek) {
        System.out.println(zprava + " = " + kolikPismenko(vysledek));
    }
}