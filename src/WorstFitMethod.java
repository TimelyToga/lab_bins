

import java.util.List;
import java.util.PriorityQueue;

public class WorstFitMethod implements BinMethod {

	@Override
	public List<Integer> prepData(List<Integer> data) {
		return data;
	}

	@Override
	public boolean shouldStack(Disk d)  {
		return d.freeSpace() > size;
	}

	
	
}
