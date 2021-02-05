import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	    ISatellite Göktürk3 = new Satellite();

        Iterator iter = Göktürk3.createIterator();

        while(iter.hasNext()) System.out.print(iter.next() + " ");
        System.out.println();
    }
}
