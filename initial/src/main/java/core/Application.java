package core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.support.CronTrigger;

import database.DBRunner;
import database.DBUpdate;
import database.DatabaseGrabber;

@SpringBootApplication
@EnableScheduling
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		LocalDateTime start = LocalDateTime.now();
		LocalDateTime hourEnd = start.plusHours(1).truncatedTo(ChronoUnit.HOURS);
		long hour = Duration.between(start, hourEnd).toMillis();
		
		
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		DBRunner.intializeData();
		ScheduledExecutorService hourBasedOperator = Executors.newScheduledThreadPool(1);
		hourBasedOperator.scheduleAtFixedRate(new DatabaseGrabber(), hour, 3600000, TimeUnit.MILLISECONDS);
		
		ScheduledExecutorService quMinuteBasedOperator = Executors.newScheduledThreadPool(1);
		quMinuteBasedOperator.scheduleAtFixedRate(new DBUpdate(), 15000, 15000, TimeUnit.MILLISECONDS);
        try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
