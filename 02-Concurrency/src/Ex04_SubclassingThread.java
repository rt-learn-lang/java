// This example demonstrates that there are two running threads and their order of execution can vary.
// Observe that the IDs order is random.

class Ex04_SubclassingThread {
	public static void main(String[] args) {
		ThreadSubclass ct = new ThreadSubclass();
		ct.start();
	}
}