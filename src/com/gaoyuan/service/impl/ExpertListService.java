package com.gaoyuan.service.impl;

import com.gaoyuan.base.BaseService;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.dao.IExpertListDao;
import com.gaoyuan.dao.impl.ExpertListDao;
import com.gaoyuan.service.IExpertListService;
import com.gaoyuan.utils.MyStringUtils;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午6:24:53
 * @details 
 */
public class ExpertListService extends BaseService implements IExpertListService{

	IExpertListDao iExpertListDao=new ExpertListDao();
	@Override
	public boolean saveExpert(Expert expert) {
		if(iExpertListDao.select(expert.getId_expert())!=null)return false;
		//这里同时保存为普通用户信息
		boolean isSaveExpert=iExpertListDao.saveExpert(expert);
		return isSaveExpert;
	}

}
