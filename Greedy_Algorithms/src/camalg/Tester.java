package camalg;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tester {
	static DecimalFormat df = new DecimalFormat("#.###");

	public static void main(String[] args) {
		ArrayList<Item> itemArr = new ArrayList<Item>(); // using an arraylist to quickly change the factor of each
															// item, and to easily insert all elements into a MaxHeap
		itemArr.add(new Item(0, 23, 505));
		itemArr.add(new Item(1, 26, 352));
		itemArr.add(new Item(2, 20, 458));
		itemArr.add(new Item(3, 18, 220));
		itemArr.add(new Item(4, 32, 354));
		itemArr.add(new Item(5, 27, 414));
		itemArr.add(new Item(6, 29, 498));
		itemArr.add(new Item(7, 26, 545));
		itemArr.add(new Item(8, 30, 473));
		itemArr.add(new Item(9, 27, 543));

		/**
		 * prioritize all the items by weight to value ratio create a maxMaxHeap of
		 * these items and print then while we haven't reached the weight limit, add
		 * items to new collection
		 */
		System.out.println("MaxHeap with priority based on the items value");
		for (Item i : itemArr)
			i.factorByValue(); // factor is the same as priority
		MaxHeap valueHeap = new MaxHeap();
		for (Item i : itemArr)
			valueHeap.insert(i);
		valueHeap.print();

		// create a bag and add items from the MaxHeap until weight limit is reached,
		// use helper method
		ArrayList<Item> bag1 = new ArrayList<Item>();
		addItemsToBag(67, bag1, valueHeap);
		System.out.println("\nPrinting bag 1 - priority based on value");
		printItems(bag1);

		// now we will prioritize the items by lightest items first
		System.out.println("\n\nMaxHeap with priority based on the lightest weight");
		for (Item i : itemArr)
			i.factorByLightest(); // factor is the same as priority
		MaxHeap lightHeap = new MaxHeap();
		for (Item i : itemArr)
			lightHeap.insert(i);
		lightHeap.print();

		// create a bag and add items from the MaxHeap until weight limit is reached,
		// use helper method
		ArrayList<Item> bag2 = new ArrayList<Item>();
		addItemsToBag(67, bag2, lightHeap);
		System.out.println("\nPrinting bag 2 - priority based on lightest items");
		printItems(bag2);

		// now we will prioritize the items by their value to weight ratio
		System.out.println("\n\nMaxHeap with priority based on value to weight ratio");
		for (Item i : itemArr)
			i.factorByVWRatio(); // factor is the same as priority
		MaxHeap vwHeap = new MaxHeap();
		for (Item i : itemArr)
			vwHeap.insert(i);
		vwHeap.print();

		// create a bag and add items from the MaxHeap until weight limit is reached,
		// use helper method
		ArrayList<Item> bag3 = new ArrayList<Item>();
		addItemsToBag(67, bag3, vwHeap);
		System.out.println("\nPrinting bag 3 - priority based on value to weight ratio");
		printItems(bag3);

	}

	static void addItemsToBag(double weightLimit, ArrayList<Item> bag, MaxHeap MaxHeap) {
		while (MaxHeap.size > 0) {
			Item currItem = MaxHeap.deleteRoot();
			double currWeight = currItem.weight; // get the weight of the item we are removing
			if (currWeight <= weightLimit) {
				bag.add(currItem);
				weightLimit -= currWeight;
			}
		}
	}

	static void printItems(ArrayList<Item> list) {
		int totalValue = 0;
		System.out.print("Item#\t");
		for (Item i : list)
			System.out.print(i.ID + "\t");
		System.out.print("\nValue\t");
		for (Item i : list) {
			System.out.print(i.value + "\t");
			totalValue += i.value;
		}
		System.out.print("\nWeight\t");
		for (Item i : list) {
			System.out.print(i.weight + "\t");
		}
		System.out.print("\nFactor\t");
		for (Item i : list) {
			System.out.print(df.format(i.factor) + "\t");
		}
		System.out.println("\nTotal Bag Value = " + totalValue);
		System.out.println();
	}

}
