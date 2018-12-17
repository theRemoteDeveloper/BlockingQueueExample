import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;
	
	public Producer (BlockingQueue<Message> q) {
		this.queue=q;
	}
	
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
		Message msg = new Message(" "+i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced: "+msg.getMsg());
			} catch(InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
		}
		
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
