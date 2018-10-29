package bukai_20181023;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class ClientThread extends Thread{
	private Random random;
	private RequestQueue queue;

	public ClientThread(RequestQueue queue, String name, long seed) {
		super(name);
		this.queue = queue;
		this.random = new Random(seed);
	}

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			Request request = new Request(String.format("No.%s", i));
			log.info("プットします{}",request);
			queue.putRequest(request);
			sleep(random.nextInt(1000));
		}

	}

	private void sleep(int interval) {
		try {
			Thread.sleep(interval);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}


