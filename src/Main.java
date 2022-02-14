import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../out/input")) ;
        long l = sc.nextInt();
        System.out.println(l);
        long r = sc.nextInt();
        System.out.println(r);
        Node n = new Node(l, r, 0);
        System.out.println("[" + n.l + " " + n.r + "] Build started.");

        long time = System.currentTimeMillis();
        long lcm=l;
        long gcd=l;
        for(long i=l+1; i<=r; i++){
                gcd = findGCD(i, lcm);
                lcm = (lcm*i)/gcd;
            }

        System.out.println("LCM: "+lcm +" Build finished. Execution time: " + (System.currentTimeMillis() - time)/1000.0 + "s");

        System.out.println();
    }

    //recursive function to find GCD of two numbers
    public static long findGCD(long a, long b){
        //base condition
        if(b == 0)
            return a;

        return findGCD(b, a%b);
    }

}
