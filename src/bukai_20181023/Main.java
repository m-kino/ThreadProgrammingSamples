package bukai_20181023;

public class Main {
	public static void main(String[] args) {
		RequestQueue queue = new RequestQueue();
		new ClientThread(queue,"Alice",3141592L).start();

		//Sleep(5000);
		new ServerThread(queue,"Bobby",6535897L).start();

	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
