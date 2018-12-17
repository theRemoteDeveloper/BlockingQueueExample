import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Message> queue;
	
	public Consumer(BlockingQueue<Message> q) {
		this.queue=q;
	}

	@Override
	public void run() {
		try {
			Message msg;
			while((msg=queue.take()).getMsg() != "exit") {
				Thread.sleep(1000);
				System.out.println("Consumed:"+msg.getMsg());
			}
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
