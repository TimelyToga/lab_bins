

import java.util.List;
import java.util.PriorityQueue;

public interface BinMethod {
	
	public List<Integer> prepData(List<Integer> data);
	
	public boolean shouldStack(Disk d, int size);
	
	public String getName();

}
