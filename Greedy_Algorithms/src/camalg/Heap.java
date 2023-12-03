package camalg;

public class Heap {
	final int MAX_SIZE = 20; // max capacity of the heap
	int size; // tracks CURRENT size / current # of elements in the heap
	Item[] arr; // array keeping the elements within the heap

	public Heap() {
		arr = new Item[MAX_SIZE];
		size = 0;
	}

	boolean insert(Item element) {
		if (size >= MAX_SIZE) {
			return false;
		}
		arr[size] = element;
		percolateUP(size++);

		return true;
	}

	/**
	 * 
	 * @param index
	 * 
	 *              
	 */
	void percolateUP(int index) {
		int parent = (index-2)/2; //index of parent
		while (parent >= 0 && index > parent) {
			// first we make sure the parent index is not out of bounds, then if the childs index is greater than the parent, we swap
			swap(index,parent);
		} 
	}
	
	//simple swap function
	void swap(int index1, int index2) {
		Item temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	void print() {
		for (int i = 0; i < MAX_SIZE; i++) {
			System.out.print(i + "\t");
		}
		for (Item i : arr) {
			System.out.print(i.factor + "\t");
		}
	}
}
