import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    // kdy na metodu zavolam .invoke, tak ji zavolam
    // neexistuji metody, ktere by menily obsah promenne, za to existuji takobyhle metody pro retezce
    // proto:
    // str s1 = "la"; str s2 = s1; s1 = s1 + "la"; .... sout(s2) -> la
    // list l1 = {1,2,3}; list l2 = l1; l1.add(4); .... sout(l2) -> 1 2 3 4

    // @ = anotace, napr @Override = muj predek tuto metodu ma, ja ji jneom prepisuji
    // Lombok = knihovna anotaci

    public static void main(String[] args) {
        Object obj = "la";
        Class<?> trida = obj.getClass();
        Method[] metody = obj.getClass().getMethods();

        System.out.println("Trida " + trida + " ma metody: ");
        for (Method m: metody) {
            String jmeno = m.getName();
            System.out.print(jmeno + ": ");
            Parameter[] parameters = m.getParameters();
            for (Parameter p: parameters) {
                System.out.print(p.getName() + " ");
            }
            System.out.println();
        }

        // ukazka anotace z lomboku
        System.out.println("jina uloha");
        System.out.println();
        MojeTrida mt = new MojeTrida();
        System.out.println(mt);
    }
}