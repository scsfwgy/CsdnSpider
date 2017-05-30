package com.gaoyuan.pipeline;

import java.util.Map;

import com.gaoyuan.bean.Expert;
import com.gaoyuan.dao.IExpertListDao;
import com.gaoyuan.dao.impl.ExpertListDao;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午2:50:17
 * @details 
 */
public class ExpertListPipeLine implements Pipeline{
	IExpertListDao iExpertListDao=new ExpertListDao();
	@Override
	public void process(ResultItems resultItems, Task task) {
		  for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
	            System.out.println(entry.getKey() + ":\t" + entry.getValue());
		  }
	}
	
}
