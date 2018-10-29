package bukai_20181023;

import java.util.LinkedList;

public class RequestQueue {

	private LinkedList<Request> queueList = new LinkedList<Request>();

	public void putRequest(Request request) {
		queueList.add(request);
		this.notifyAll();
	}

	public synchronized Request getRequest() {
		while(queueList.size() <= 0) {
			try {
				this.wait();
			}catch(InterruptedException e) {
			}
		}

		return queueList.removeFirst();
	}

}