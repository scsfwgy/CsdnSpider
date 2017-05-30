package com.gaoyuan.spider;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import com.gaoyuan.base.BaseSpider;
import com.gaoyuan.base.Contents;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.service.IExpertListService;
import com.gaoyuan.service.impl.ExpertListService;
import com.gaoyuan.utils.MyStringUtils;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午2:42:33
 * @details
 */
public class ExpertListSpider extends BaseSpider {
	IExpertListService iExpertListService=new ExpertListService();
	
	// 这个是博客专家列表页
	public static final String EXPERTS_LIST =Contents.Blog.EXPERTS_LIST;
	private Site site = Site
			.me()
			.setDomain("blog.csdn.net")
			.setSleepTime(100)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	// 标记当前专家类型以及类型名；
	private int typeId;
	private String typeName;

	public ExpertListSpider(int typeId2) {
				this.typeId=typeId2;
				// set typeName
				if (typeId == 1) {
					this.typeName = "移动开发";
				} else if (typeId == 14) {
					this.typeName = "Web前端";
				} else if (typeId == 15) {
					this.typeName = "架构设计";
				} else if (typeId == 16) {
					this.typeName = "编程语言";
				} else if (typeId == 17) {
					this.typeName = "互联网";
				} else if (typeId == 6) {
					this.typeName = "数据库";
				} else if (typeId == 12) {
					this.typeName = "系统运维";
				} else if (typeId == 2) {
					this.typeName = "云计算";
				} else if (typeId == 3) {
					this.typeName = "研发管理";
				} else {
					this.typeName = "未知分类";
				}
	}

	@Override
	public void process(Page page) {
		// 列表页： 这里进行匹配，匹配出列 表页进行相关处理。
		if ((page.getUrl()).regex(EXPERTS_LIST).match()) {
			// 遍历出div[@class=\"page_nav\"]节点下的所有超链接，这里的超链接是分页的超链接，可以进行分页。
			page.addTargetRequests(page.getHtml()
					.xpath("//div[@class=\"page_nav\"]").links()
					.regex(EXPERTS_LIST).all());// 是一个正则规则，校验使用，可以省略。

			// 获取专家列表元素
			Elements expertList_elements = page.getHtml().getDocument()
					.getElementsByClass("experts_list");

			for (Element element : expertList_elements) {
				// 两个根节点
				Element tag_dt = element.getElementsByTag("dt").get(0);
				Element tag_dd = element.getElementsByTag("dd").get(0);
				// 获取用户id
				String id_expert = MyStringUtils.getLastSlantContent(tag_dt
						.getElementsByTag("a").get(0).attributes().get("href"));
				// 获取用户头像
				String headImg = tag_dt.getElementsByTag("a").get(0)
						.getElementsByClass("expert_head").get(0).attributes()
						.get("src");
				// 获取用户名
				String name = tag_dd.getElementsByTag("a").get(0).text();
				String address_job = tag_dd.getElementsByTag("div").get(0)
						.text();
				// 获取地址
				String localtion = MyStringUtils
						.getBeforeVercitalLine(address_job);
				// 获取职位
				String job = MyStringUtils.getAfterVercitalLine(address_job);
				// 获取文章数
				String articleNums = tag_dd.getElementsByTag("div").get(1)
						.getElementsByTag("div").get(1).getElementsByTag("b")
						.get(0).text();
				// 获取阅读数
				// TODO:这里逻辑不太对呀，但是结果正确
				String readNums = tag_dd.getElementsByTag("div").get(1)
						.getElementsByTag("div").get(2).getElementsByTag("b")
						.get(0).text();

				// 开始组装数据
				Expert expert = new Expert();
				expert.setArticleNums(articleNums);
				expert.setHeadImg(headImg);
				expert.setId_expert(id_expert);
				expert.setJob(job);
				expert.setLocaltion(localtion);
				expert.setName(name);
				expert.setReadNums(readNums);
				expert.setTypeId(this.typeId);
				expert.setTypeName(this.typeName);
				expert.setId(MyStringUtils.getGUID());
				if (isLog())
					System.out.println(expert.toString());
				// save
				boolean isSave = false;
				if (isDb())
					isSave = iExpertListService.saveExpert(expert);
				if (isDbLog())
					System.out.println(isSave);
			}

		}
	}

	@Override
	public Site getSite() {
		return site;
	}
	//Test
	public static void main(String[] args) {
		process();
	}

	// 程序入口
	public static void process() {
		spiderByTypeId(1);// 移动开发
		spiderByTypeId(14);// web前端
		spiderByTypeId(15);// 架构设计
		spiderByTypeId(16);// 编程语言
		spiderByTypeId(17);// 互联网
		spiderByTypeId(6);// 数据库
		spiderByTypeId(12);// 系统运维
		spiderByTypeId(2);// 云计算
		spiderByTypeId(3);// 研发管理
		spiderByTypeId(0);// all,need filtter abover
	}

	// 获取专家所属id
	private static void spiderByTypeId(int typeId) {
		ExpertListSpider expertListSpider = new ExpertListSpider(typeId);
		expertListSpider.setDb(true);
		expertListSpider.setDbLog(true);
		expertListSpider.setLog(true);
		Spider.create(expertListSpider)
				.addUrl("http://blog.csdn.net/peoplelist.html?channelid="
						+typeId + "&page=1").addPipeline(null).thread(10).run();
	
	}
}
