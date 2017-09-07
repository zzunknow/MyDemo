import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 批量定时任务
 * @author zou
 *
 */
public class TimerDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Map<Integer,ScheduledFuture<?>> tasks = new HashMap<Integer,ScheduledFuture<?>>(1000000);
		
		System.out.println(System.currentTimeMillis());
		//定时任务管理器
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//批量生成定时任务
		for(int i=0;i<10;i++){
			ScheduledFuture<?> s = service.schedule(new Task(i), 3, TimeUnit.SECONDS);
			tasks.put(i, s);
		}
		
		
		//取消任务
		/*for(int i=90000;i<100000;i++){
			tasks.get(i).cancel(true);
		}*/
	}
}

class Task implements Runnable{
	
	private int id;
	
	public Task(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis()+"正在执行："+id);
	}
	
}
