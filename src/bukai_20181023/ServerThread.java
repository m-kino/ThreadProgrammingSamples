package bukai_20181023;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerThread extends Thread{
	private RequestQueue queue;

	private Random random;

	public ServerThread(RequestQueue queue, String name, long seed) {
		super(name);
		this.queue = queue;
		this.random = new Random(seed);
	}

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			Request request = queue.getRequest();
			log.info("取り出しました{}",request);
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


