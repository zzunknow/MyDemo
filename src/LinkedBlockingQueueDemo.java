import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue实现是线程安全的，实现了先进先出等特性，是作为生产者消费者的首选
 * @author zou
 *
 */
public class LinkedBlockingQueueDemo {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		System.out.println(queue.size());
        for (int i=0; i<10; ++i) {
            // queue.put("aa");  // 阻塞
            System.out.println(queue.offer("aa") ); // 非阻塞
        }
        System.out.println(queue+"|"+queue.size());
        for (int i=0; i<10; ++i) {
            // System.out.println( queue.remove() );  // 非阻塞，空时抛出异常
             System.out.println(queue.poll() ); // 非阻塞，空时返回空
            //System.out.println( queue.take() ); // 若为空则阻塞
        }
        System.out.println(queue);
	}
}
