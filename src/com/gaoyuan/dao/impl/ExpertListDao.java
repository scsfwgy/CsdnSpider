package com.gaoyuan.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gaoyuan.base.BaseDao;
import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.dao.IExpertListDao;
import com.gaoyuan.utils.C3p0Utils;


/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午5:42:21
 * @details 
 */
public class ExpertListDao extends BaseDao implements IExpertListDao {

	@Override
	public boolean saveExpert(Expert expert) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into expert(id,id_expert,name,headImg,localtion,"
				+ "job,articleNums,readNums,"
				+ "createTime,stamp,spare1,spare2,typeId,typeName) value(?,?,?,?,?,?,?,?,?,null,?,?,?,?)";

		Object[] param = { expert.getId(), expert.getId_expert(),
				expert.getName(), expert.getHeadImg(), expert.getLocaltion(),
				expert.getJob(), expert.getArticleNums(), expert.getReadNums(),
				expert.getCreateTime(),
 expert.getSpare1(),
				expert.getSpare2(), expert.getTypeId(), expert.getTypeName() };
		try {
			int flag = runner.update(sql, param);
			if (flag > 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Expert select(String id_expert) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Expert where id_expert = ?";
		try {
			Expert author = runner.query(sql, new BeanHandler<Expert>(
					Expert.class), id_expert);
			return author;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
