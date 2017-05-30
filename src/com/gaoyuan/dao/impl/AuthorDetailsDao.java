package com.gaoyuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gaoyuan.base.BaseDao;
import com.gaoyuan.base.Contents;
import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Blog;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.dao.IAuthorDetailsDao;
import com.gaoyuan.dao.IExpertListDao;
import com.gaoyuan.utils.C3p0Utils;
import com.gaoyuan.utils.MyStringUtils;


/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午5:42:21
 * @details 
 */
public class AuthorDetailsDao extends BaseDao implements IAuthorDetailsDao {

	@Override
	public boolean saveAuthorDetails(Author author) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into author("
				+ "id,id_author,name,headImg,viewNums,"
				+ "points,rank,originalNums,repuishNums,translateNums,"
				+ "commentNums,title,descb,isBlogExpert,isPreBlogExpert,"
				+ "isPersist,isColumnUp,isBlogStars,isMicrMvp,blogColumns,createTime,"
				+ "stamp,spare1,spare2,fromExpert) value(?,?,?,?,?"
				+ ",?,?,?,?,?" + ",?,?,?,?,?" + ",?,?,?,?,?,?" + ",?,?,?,?)";

		Object[] param = { author.getId(), author.getId_author(),
				author.getName(), author.getHeadImg(), author.getViewNums(),
				author.getPoints(), author.getRank(), author.getOriginalNums(),
				author.getRepuishNums(), author.getTranslateNums(),
				author.getCommentNums(), author.getTitle(), author.getDescb(),
				author.isBlogExpert(), author.isPreBlogExpert(),
				author.isPersist(), author.isColumnUp(), author.isBlogStars(),
				author.isMicrMvp(), author.getBlogColumns(),
				author.getCreateTime(), author.getStamp(), author.getSpare1(),
				author.getSpare1(), author.isFromExpert() };
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
	public Author selectAuthor(String id_Author) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from author where id_author = ?";
		try {
			Author author = runner.query(sql, new BeanHandler<Author>(
					Author.class), id_Author);
			return author;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Object selectBlog(String id_blog) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Blog where id_blog = ?";
		try {
			Blog blog = runner.query(sql, new BeanHandler<Blog>(Blog.class),
					id_blog);
			return blog;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean saveBlog(Blog blog) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into blog("
				+ "id,id_blog,author,title,isTop,"
				+ "type,detailsUrl,publishDateTime,viewNums,commentNums,"
				+ "summary,details,upNums,downNums,id_author,"
				+ "createTime,stamp,spare1,spare2,fromExpert,headImg,typeId) value(?,?,?,?,?"
				+ ",?,?,?,?,?"
 + ",?,?,?,?,?" + ",?,?,?,?,?,?,?)";

		Object[] param = { blog.getId(), blog.getId_blog(), blog.getAuthor(),
				blog.getTitle(), blog.getIsTop(), blog.getType(),
				blog.getDetailsUrl(), blog.getPublishDateTime(),
				blog.getViewNums(), blog.getCommentNums(), blog.getSummary(),
				blog.getDetails(), blog.getUpNums(), blog.getDownNums(),
				blog.getId_author(), blog.getCreateTime(), blog.getStamp(),
				blog.getSpare1(), blog.getSpare2(), blog.isFromExpert(),blog.getHeadImg(),blog.getTypeId() };
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
	public List<Expert> getExpertListByPager(int currentPager, int pagerSize) {
		String sql = "select * from Expert limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Expert> expertList = queryRunner.query(sql,
					new BeanListHandler<Expert>(Expert.class),
					MyStringUtils.getParam1(currentPager,pagerSize), pagerSize);
			return expertList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Author> getAuthortListByPager(int currentPager, int pagerSize) {
		String sql = "select * from Author limit ?,?";
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Author> expertList = queryRunner.query(sql,
					new BeanListHandler<Author>(Author.class),
					MyStringUtils.getParam1(currentPager,pagerSize), pagerSize);
			return expertList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Expert selectExpert(String id_author) {
		//
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Expert where id_expert = ?";
		try {
			Expert blog = runner.query(sql, new BeanHandler<Expert>(Expert.class),
					id_author);
			return blog;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
