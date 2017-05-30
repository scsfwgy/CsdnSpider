package com.gaoyuan.dao;

import com.gaoyuan.bean.Expert;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午5:41:38
 * @details 
 */
public interface IExpertListDao {

	boolean saveExpert(Expert expert);

	Expert select(String id_expert);

}
