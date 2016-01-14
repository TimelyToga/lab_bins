import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Runs a number of algorithms that try to fit files onto disks.
 */
public class Bins {
    public static final String DATA_FILE = "example.txt";

    /**
     * Reads list of integer data from the given input.
     *
     * @param input tied to an input source that contains space separated numbers
     * @return list of the numbers in the order they were read
     */
    public List<Integer> readData (Scanner input) {
        List<Integer> results = new ArrayList<Integer>();
        while (input.hasNext()) {
            results.add(input.nextInt());
        }
        return results;
    }

    /**
     * The main program.
     */
    public static void main (String args[]) {
        Bins b = new Bins();
        Scanner input = new Scanner(Bins.class.getClassLoader().getResourceAsStream(DATA_FILE));
        List<Integer> data = b.readData(input);
        List<BinMethod> methodList = new ArrayList<BinMethod>();
        
        
        // Initialize various methods into `methodList`
        methodList.add(new WorstFitMethod());
        methodList.add(new WorstFitDecreasingMethod());
        
        // Iterate through list of methods
        for(BinMethod method : methodList){    
        	// Prep
        	List<Integer> tempData =  method.prepData(data);
        	
            PriorityQueue<Disk> pq = new PriorityQueue<Disk>();
            pq.add(new Disk(0));
            int diskId = 1;
            int total = 0;
        	
        	// Iterate through every file and determine where to place it
        	for(Integer size: tempData){
                Disk d = pq.peek();
                if (method.shouldStack(d, size)) {
                	// Add curFile to existing disk
                    pq.poll();
                    d.add(size);
                    pq.add(d);
                } else {
                	// Add curFile to new disk
                    Disk d2 = new Disk(diskId);
                    diskId++;
                    d2.add(size);
                    pq.add(d2);
                }
                total += size;
        	}
        
            System.out.println("total size = " + total / 1000000.0 + "GB");
            System.out.println();
            System.out.println(method.getName());
            System.out.println("number of pq used: " + pq.size());
            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
            System.out.println();
        }
    }
}
