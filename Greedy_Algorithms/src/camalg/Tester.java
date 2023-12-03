package camalg;

public class Tester {
	public static void main(String[] args) {
		Item i0 = new Item(0, 23, 505);
		Item i1 = new Item(1, 26, 352);
		Item i2 = new Item(2, 20, 458);
		Item i3 = new Item(3, 18, 220);
		Item i4 = new Item(4, 32, 354);
		Item i5 = new Item(5, 27, 414);
		Item i6 = new Item(6, 29, 498);
		Item i7 = new Item(7, 26, 545);
		Item i8 = new Item(8, 30, 473);
		Item i9 = new Item(9, 27, 543);

		Heap heap0 = new Heap();
		heap0.insert(i0);
		heap0.insert(i1);
		heap0.insert(i2);
		heap0.insert(i3);
		heap0.insert(i4);
		heap0.insert(i5);
		heap0.insert(i6);
		heap0.insert(i7);
		heap0.insert(i8);
		heap0.insert(i9);
	}
}
