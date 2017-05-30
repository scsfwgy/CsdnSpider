package com.gaoyuan.timer;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gaoyuan.bean.Expert;
import com.gaoyuan.service.IAuthorDetailsService;
import com.gaoyuan.service.impl.AuthorDetailsService;
import com.gaoyuan.spider.AuthorDetailsSpider;
import com.gaoyuan.utils.MyStringUtils;

public class Expert2AuthorTask implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("开始博客专家到作者的爬取。。。"+MyStringUtils.getCurrentDateTime());
		IAuthorDetailsService iAuthorDetailsService=new AuthorDetailsService();
		AuthorDetailsSpider expertListSpider=new AuthorDetailsSpider();
		expertListSpider.setLog(false);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(false);
		int i=0;
		while(true){
			List<Expert> expertListByPager = iAuthorDetailsService.getExpertListByPager(i++,10);
			if(expertListByPager.isEmpty())return;
			for (Expert expert : expertListByPager) {
				expertListSpider.process(expertListSpider,expert.getId_expert());
			}
			
		}
	}
}
