import java.util.*;
import java.io.File;

import parcs.*;

public class Bluck {
    private final static int NODES = 4;

    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("LCM.jar");
        ArrayList<Node> nodes = fromFile(curtask.findFile("input"));
        List<Integer> x = new ArrayList<>();
        AMInfo info = new AMInfo(curtask, null);
        LinkedList<channel> channels = new LinkedList<>();
        for(Node n: nodes) {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("LCM");
            c.write(n);
            channels.add(c);
        }
        System.out.println("Waiting for result...");
        for (var c : channels) {
            x.add(c.readLong());
        }
    long lcm = x.get(0);
    long gcd = x.get(0);
    for(long i=1; i<x.size(); i++){
      gcd = findGCD(x.get(i), lcm);
      lcm = (lcm*x.get(i))/gcd;
    }
    System.out.println("LCM: "+lcm);
        curtask.end();
    }
    }
 private static long findGCD(long a, long b){
    //base condition
    if(b == 0)
      return a;
    
    return findGCD(b, a%b);
  }
    private static ArrayList<Node> fromFile(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        System.out.println("created scanner");
        int l = sc.nextInt();
        System.out.println(l);
        int r = sc.nextInt();
        System.out.println(r);
        ArrayList<Node> res = new ArrayList<>();
        for (int i = 0; i < NODES; i++) {
            res.add(new Node(l, r, i));
        }
        return res;
    }
}
