package my.learning.optimal;

import java.util.ArrayList;
import java.util.List;

public class Bin {

	private int id;
	private int size;
	private int capacity;
	private List<Integer> list;
	
	public Bin(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.size = capacity;
		list = new ArrayList<Integer>();
	}
	
	public boolean put(int itemSize) {
		if(itemSize > this.size) return false;
		this.size = this.size - itemSize;
		list.add(itemSize);
		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("Bin with id #");
		sb.append(id).append(" of capacity(")
		.append(this.capacity).append("): ").append(list);
		
		return sb.toString();
		
	}
	
}
