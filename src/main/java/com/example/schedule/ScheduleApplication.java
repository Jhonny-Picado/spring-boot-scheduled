package com.example.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScheduleApplication {

	Logger logger = Logger.getLogger(ScheduleApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	// Schedule a job to run every 10 seconds using fixedRate
	@Scheduled(fixedRate = 10000)
	public void scheduleFixedRateTask() {
		logger.info("Job Current Time (FixedRate): " + new Date());
	}

	// Schedule a job to run every 5 seconds using fixedDelay
	@Scheduled(fixedDelay = 5000)
	public void scheduleFixedDelayTask() {
		logger.info("Job Current Time (FixedDelay): " + new Date());
	}

	@Async // Run the task asynchronously. It supports parallel execution.
	@Scheduled(fixedRate = 1000)
	public void scheduleFixedRateTaskAsync() throws InterruptedException {
		logger.info("Job Current Time (FixedRateAsync): " + new Date());
		Thread.sleep(2000);
	}

	// Schedule a job to run every 1 second with an initial delay of 1 second
	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleFixedRateWithInitialDelayTask() {
		logger.info("Job Current Time (FixedRateWithInitialDelayTask): " + new Date());
	}

	// Schedule a job to run in a specific time using cron expression
	// A=Seconds(0-59), B=Minutes(0-59), C=Hours(0-23), D=Day of month(1-31), E=Month(1-12), F=Day of week(0-6)
	// * = any value, ? = any value, - = range, / = increment, L = last, W = weekday, # = nth
	// Example: 0 30 18 * * *  = Every day at 18:30
					 //A B  C  D  E F
	@Scheduled(cron = "0 30 19 * * ?")
	public void scheduleTaskUsingCronExpression() {
		logger.info("Job Current Time (CronExpression): " + new Date());
	}

}
