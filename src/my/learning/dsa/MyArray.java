package my.learning.dsa;

public class MyArray {
	
	private int[] items;
	private int count;
	
	public MyArray(int length) {
		items = new int[length];
	}
	
	public void insert(int item) {
		if(count == items.length) {
			int[] newItems = new int[2*count];
			for(int i=0; i<count; i++) {
				newItems[i] = items[i];
			}
			items = newItems;			
		}
		
		items[count++] = item; 
	}
	
	public int indexOf(int item) {
		for(int i=0; i<count;i++)
			if(item == items[i])
				return i;
		
		return -1;
	}
	public void removeAt(int index) {
		if(index<0 || index>=count)
			throw new IndexOutOfBoundsException();
		
		for(int i=index;i<count;i++) 
			items[i] = items[i+1];
		count--;
	}
	
	public void print() {
		for(int i =0; i<count; i++)
			System.out.println(items[i]);
	}

	public static void main(String[] args) {		
		MyArray numbers = new MyArray(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		System.out.println(numbers.indexOf(50));
		numbers.print();
	}

}
