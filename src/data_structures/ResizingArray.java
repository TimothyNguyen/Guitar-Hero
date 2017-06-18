package data_structures;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author macintosh
 *
 * @param <Item>
 * 
 * Implements a generic stack using a resizing array
 * Dynamically adjust the size of the array so that it is both
 * sufficiently large to hold all of the items and not so large
 * as to waste an excessive amount of space.
 * 
 * We double the size of the array in push() if it is full; we halve
 * the size of the array in pop() if it is less than 1/4 full
 */

public class ResizingArray<Item> implements Iterable<Item> {

	private Item[] a;	// array of items
	private int n;		// number of elements on stack

	/**
	 *  Initalizes an empty stack
	 */
	public ResizingArray() {
		// TODO Auto-generated constructor stub
		n = 0;
		a = (Item[]) new Object[n];
	}

	/**
	 * Is this stack empty?
	 * @ return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of items in the stack.
	 * @return the number of items in the stack
	 */
	public int length() {
		return n;
	}

	// resize the underlying array holding the elements
	private void resize(int capacity) {
		assert capacity >= n;

		// Move stack of size N <= max to a new array of size max.
		Item[] temp = (Item[]) new Object[capacity];
		for(int i = 0; i < n; i++)
			temp[i] = a[i];
		a = temp;
	}

	/**
	 * Adds the item to this stack
	 * @param item the item to add
	 */
	public void add(Item item) {
		if(n == a.length) resize(1+a.length);	// double size of array if necessary
		a[n++] = item;
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * @return the item most recently added
	 * @throws java.util.NoSuchElementException if this stack is empty
	 */
	public Item remove() {
		if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
		Item item = a[n-1];
		a[n-1] = null;		// to avoid loitering
		n--;
		// shrink size of array if necessary
		if(n > 0 && n == a.length/4) resize(a.length/2);
		return item;
	}


	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO order.
	 * @return an iterator to this stack that iterates through the items in LIFO order.
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i;

		public ArrayIterator() {
			i = n-1;
		}

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			return a[i--];
		}
	}
}
