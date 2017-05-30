package com.gaoyuan.base;


import us.codecraft.webmagic.processor.PageProcessor;


/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午2:05:08
 * @details 
 */
public abstract class BaseSpider extends BaseClass implements PageProcessor{
	//是否显示爬虫日志信息
	protected boolean isLog=false;
	//是否之持久化
	protected boolean isDb=true;
	//是否显示数据库操作反馈
	protected boolean isDbLog=true;
	
	public boolean isDbLog() {
		return isDbLog;
	}
	public void setDbLog(boolean isDbLog) {
		this.isDbLog = isDbLog;
	}
	public boolean isLog() {
		return isLog;
	}
	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}
	public boolean isDb() {
		return isDb;
	}
	public void setDb(boolean isDb) {
		this.isDb = isDb;
	}
	
   
}
