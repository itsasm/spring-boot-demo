package com.java.api.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.java.api.controller.ApiController;

@Component
public class Scheduler {

	private static Logger logger = LoggerFactory.getLogger(Scheduler.class);

	@Autowired
	private ApiController apiController;

	//@Scheduled(fixedRate = 5000)
	public void myScheduler() {
		String str = apiController.getRequest();
		logger.debug("From Scheduler : " + str);
	}

	//second, minutes, hours, date, month, day-of-the-week
	@Scheduled(cron = "* 30 17 31 * ?")
	public void myScheduler_1() {
		String str = apiController.getRequest();
		logger.debug("From Other Scheduler : " + str);
	}
}
