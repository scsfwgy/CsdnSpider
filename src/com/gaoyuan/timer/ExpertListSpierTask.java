package com.gaoyuan.timer;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gaoyuan.spider.ExpertListSpider;
import com.gaoyuan.utils.MyStringUtils;

public class ExpertListSpierTask implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("开始爬取博客专家。。。"+MyStringUtils.getCurrentDateTime());
		ExpertListSpider.process();
	}
}
