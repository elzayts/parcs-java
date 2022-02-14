import parcs.*;

public class LCM implements AM {
    private static final int NODES = 4;

    public static long findGCD(long a, long b){
        //base condition
        if(b == 0)
            return a;

        return findGCD(b, a%b);
    }
  
    public void run(AMInfo info) {
        Node n = (Node) info.parent.readObject();
        System.out.println("[" + n.l + " " + n.r + "] Build started.");
 
       long lcm=n.l;
       long gcd=n.l;
        while (start % NODES != n.div) start++;
        for (long i = start; i <= n.r; i += NODES) {
            gcd = findGCD(i, lcm);
                lcm = (lcm*i)/gcd;
        }
        System.out.println("[" + n.l + " " + n.r + "] Build finished.");
        info.parent.write(lcm);
    }
}
