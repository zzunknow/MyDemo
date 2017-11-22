import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * logback使用demo
 * 使用包
 * org.slf4j	--->		slf4j-api-1.7.9.jar
 * ch.qos.logback.core -->	logback-core-1.2.3.jar
 * ch.qos.logback.classic->	logback-classic-1.2.3.jar
 * @author zou
 *
 */
public class LogDemo {

	private static Logger log = LoggerFactory.getLogger(LogDemo.class);
	
	public static void main(String[] args) {
		log.error("error.....");
		log.warn("warn....");
		log.info("info.....");
		log.debug("debug.....");
		log.trace("trace.....");
		new LogTest().f1();
	}
}
class LogTest{
	private static Logger log = LoggerFactory.getLogger(LogTest.class);
	
	public void f1(){
		log.error("error.....");
		log.warn("warn....");
		log.info("info.....");
		log.debug("debug.....");
		log.trace("trace.....");
	}
}
