package sample;

public class App {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getId());
		SimpleApplication.launch(args);
		System.out.println("Exiting.");
	}

}
