package camalg;

import java.text.DecimalFormat;

public class MaxHeap {
	final int MAX_SIZE = 20; // max capacity of the heap
	int size; // tracks CURRENT size / current # of elements in the heap
	Item[] arr; // array keeping the elements within the heap
	DecimalFormat df = new DecimalFormat("#.###");

	public MaxHeap() {
		arr = new Item[MAX_SIZE];
		size = 0;
	}

	/**
	 * inserts an item into the array, then uses percolateUp to keep the heap property
	 * 
	 * @param key        Item to be inserted
	 * @return returns true or false if the element is successfully inserted
	 */
	boolean insert(Item key) {
		if (size >= MAX_SIZE) {
			return false;
		}
		arr[size] = key;
		percolateUp(size++);
		return true;
	}

	/**
	 * percolate up function to use after insertion
	 * @param index		index we start to percolate up at
	 */
	void percolateUp(int index) {
		while (((index - 1) / 2 >= 0) && arr[index].factor > arr[(index - 1) / 2].factor) {
			// first we make sure the parent index is not out of bounds, then if the childs
			// factor is greater than the parent, we swap
			swap(index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	/**
	 * The priority of the tree is based on the factor. Technically this is maxHeap,
	 * however, we manipulate the factor in order to define whether this is a
	 * maxHeap, minHeap, or something else - hence the name deleteRoot rather than
	 * deleteMin / deleteMax
	 */
	Item deleteRoot() {
		if (size == 0) {
			return null;
		}
		Item root = arr[0]; //save root value to return post deletion
		size--;				//deincrement size before we replace the root
		arr[0] = arr[size]; //replace root
		percolateDown(); // after replacing the root, we must percolate down in order to maintain heap
							// property
		return root;
	}

	void percolateDown() {
		int index = 0; // initial index we start at
		while ((index * 2) + 1 < size) { // while there is at least a left child
			int j = index * 2 + 1; // index left child
			if (j + 1 <= size && arr[j + 1].factor > arr[j].factor) // if left child is present and greater than left
																	// child, update j to represent the child's index
																	// with max value (highest priority)
				j++;
			if (index > arr[j].factor)
				break; // if the parents value is greater, we break and are finished
			swap(index, j); // if not we swap and continue
			index = j; //update index, new index to percolatedown at
		}
	}

	/**
	 * simple swap function, swaps Items at index1 and index2
	 */
	void swap(int index1, int index2) {
		Item temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/**
	 * prints the array repersentation fo the heap
	 */
	void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			if (arr[i] != null)
				System.out.print(df.format(arr[i].factor) + "\t");
		}
		System.out.println();
	}
}
