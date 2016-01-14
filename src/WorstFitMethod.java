

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WorstFitMethod implements BinMethod {
	
	private static String name = "Worst Fit Method";

	@Override
	public List<Integer> prepData(List<Integer> data) {
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
