package com.gaoyuan.timer;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gaoyuan.bean.Author;
import com.gaoyuan.service.IAuthorDetailsService;
import com.gaoyuan.service.impl.AuthorDetailsService;
import com.gaoyuan.spider.BlogListSpider;

public class Author2BlogListSpierTask implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		IAuthorDetailsService iAuthorDetailsService = new AuthorDetailsService();
		BlogListSpider expertListSpider = new BlogListSpider();
		expertListSpider.setLog(false);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(false);
		int i = 0;
		while (true) {
			List<Author> expertListByPager = iAuthorDetailsService
					.getAuthorListByPager(i++, 30);
			if (expertListByPager.isEmpty())
				return;
			for (Author expert : expertListByPager) {
				expertListSpider.process(expertListSpider,
						expert.getId_author());
			}

		}
	}
}
