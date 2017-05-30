package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.crypto.AEADBadTagException;

import junit.framework.Assert;

import org.junit.Test;

import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.service.IAuthorDetailsService;
import com.gaoyuan.service.IExpertListService;
import com.gaoyuan.service.impl.AuthorDetailsService;
import com.gaoyuan.service.impl.ExpertListService;
import com.gaoyuan.spider.AuthorDetailsSpider;
import com.gaoyuan.spider.BlogListSpider;
import com.gaoyuan.spider.ExpertListSpider;
import com.gaoyuan.utils.MyStringUtils;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午9:47:55
 * @details 
 */
public class SpiderTest {

	@Test
	public void testExpertListSpider(){
		ExpertListSpider.process();
	}
	
	@Test
	public void testAuthorDetailsSpider(){
		AuthorDetailsSpider expertListSpider=new AuthorDetailsSpider();
		expertListSpider.setLog(true);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(true);
		expertListSpider.process(expertListSpider,"wgyscsf");
	}
	@Test
	public void testBlogListSpider(){
		BlogListSpider expertListSpider=new BlogListSpider();
		expertListSpider.setLog(true);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(true);
		expertListSpider.process(expertListSpider,"wgyscsf");
	}
	//测试页码是否正确
	@Test
	public void testgetExpertListByPager(){
		IAuthorDetailsService iAuthorDetailsService=new AuthorDetailsService();
		List<Expert> expertListByPager = iAuthorDetailsService.getExpertListByPager(0,32);
		assertEquals(30, expertListByPager.size());
	}
	//测试从专家到作者信息的爬取
	@Test
	public void testExpert2Author(){
		IAuthorDetailsService iAuthorDetailsService=new AuthorDetailsService();
		AuthorDetailsSpider expertListSpider=new AuthorDetailsSpider();
		expertListSpider.setLog(true);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(true);
		int i=0;
		while(true){
			List<Expert> expertListByPager = iAuthorDetailsService.getExpertListByPager(i++,50);
			if(expertListByPager.isEmpty())return;
			for (Expert expert : expertListByPager) {
				expertListSpider.process(expertListSpider,expert.getId_expert());
			}
			
		}
	}
	
	// 测试从作者到博客信息的爬取
	@Test
	public void testAuthor2BlogList() {
		System.out.println("开始作者到博客的爬取。。。"+MyStringUtils.getCurrentDateTime());
		IAuthorDetailsService iAuthorDetailsService = new AuthorDetailsService();
		BlogListSpider expertListSpider = new BlogListSpider();
		expertListSpider.setLog(true);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(true);
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
