import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WorstFitDecreasingMethod implements BinMethod {

	private static String name = "Worst Fit Decreasing Method";
	
	@Override
	public List<Integer> prepData(List<Integer> data) {
        Collections.sort(data, Collections.reverseOrder());
		return data;
	}

	@Override
	public boolean shouldStack(Disk d, int size)  {
		return d.freeSpace() >= size;
	}

	public String getName(){
		return name;
	}
	
	
}
