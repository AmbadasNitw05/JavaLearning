package my.learning.dsa;

import java.util.NoSuchElementException;

public class MyLinkedList {

	private class Node{
		private Node next;
		private int value;
		
		private Node(int value) {
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	
	public void addLast(int item) {
		Node node = new Node(item);
		
		if(first == null)
			first = last = node;
		else {
			last.next = node;	
			last = node;
		}
	}	
	
	public void addFirst(int item) {
		Node node = new Node(item);		
		
		if(first == null)
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
			
	}
	
	public int indexOf(int item) {
		Node current = first;
		int index = 0;
		while(current != null) {
			if(current.value == item)
				return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		if(first == null)
			throw new NoSuchElementException();
		
		if(first == last) {
			first = last = null;
			return;
		}
			
		Node second = first.next;
		first.next = null;
		first = second;
	}
	
	public void removeLast() {
		if(first == null)
			throw new NoSuchElementException();
		
		if(first == last) {
			first = last = null;
			return;
		}
		
		Node current = first;
		while (current != null) {
			if(current.next == last) {
				Node previous = current;
				previous.next = null;
				last = previous;
				return;
				
			}
			current = current.next;
		}
			
	}
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		  list.addLast(10); 
		  list.addLast(20); 
		  list.addLast(30);
		 
		list.removeLast();
		System.out.println(list.contains(30));
	}
}
