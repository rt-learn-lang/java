// This example demonstrates that there are two running threads and their order of execution can vary.
// Observe that the IDs order is random.

class Ex03_ThreadIds {
	public static void main(String[] args) {
		Thread t = new Thread(() -> System.out.printf("Runnable: %d", Thread.currentThread().getId()));
		t.start();

		System.out.printf("Main: %d\n", Thread.currentThread().getId());
	}
}