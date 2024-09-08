class Ex02_UsingRunnableInterface {
	public static void main(String[] args) {
		Thread t = new Thread(() ->  System.out.println("From a runnable anonymous class"));
		t.start();
	}
}