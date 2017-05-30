package com.gaoyuan.service.impl;

import java.util.List;

import com.gaoyuan.base.BaseService;
import com.gaoyuan.base.Contents;
import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Blog;
import com.gaoyuan.bean.Expert;
import com.gaoyuan.dao.IAuthorDetailsDao;
import com.gaoyuan.dao.impl.AuthorDetailsDao;
import com.gaoyuan.service.IAuthorDetailsService;
import com.gaoyuan.utils.MyStringUtils;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午6:24:53
 * @details 
 */
public class AuthorDetailsService extends BaseService implements IAuthorDetailsService{

	IAuthorDetailsDao iAuthorDetailsDao=new AuthorDetailsDao();

	@Override
	public boolean saveAuthorDetails(Author author) {
		if(iAuthorDetailsDao.selectAuthor(author.getId_author())==null)
		return iAuthorDetailsDao.saveAuthorDetails(author);
		return false;
	}

	@Override
	public boolean saveBlog(Blog blog) {
		if(iAuthorDetailsDao.selectBlog(blog.getId_blog())==null){
			blog.setId(MyStringUtils.getGUID());
			blog.setCreateTime(MyStringUtils.getCurrentDateTime());
			//判断是否是博客专家
			Expert expert=iAuthorDetailsDao.selectExpert(blog.getId_author());
			if(expert!=null){
				blog.setFromExpert(true);
				blog.setTypeId(expert.getTypeId());
				blog.setAuthor(expert.getName());
			}
			return iAuthorDetailsDao.saveBlog(blog);
		}
			
			return false;
	}

	@Override
	public List<Expert> getExpertListByPager(int currentPager, int pagerSize) {
		return iAuthorDetailsDao.getExpertListByPager(currentPager,pagerSize>Contents.Pager.MAX_PERPAGER_SIZE?Contents.Pager.MAX_PERPAGER_SIZE:pagerSize);
	}

	@Override
	public List<Expert> getExpertListByPager(int currentPager) {
		
		return iAuthorDetailsDao.getExpertListByPager(currentPager,Contents.Pager.DEF_PERPAGER_SIZE);
	}

	@Override
	public List<Author> getAuthorListByPager(int currentPager, int pagerSize) {
		return iAuthorDetailsDao.getAuthortListByPager(currentPager,pagerSize>Contents.Pager.MAX_PERPAGER_SIZE?Contents.Pager.MAX_PERPAGER_SIZE:pagerSize);
	}

	@Override
	public List<Author> getAuthorListByPager(int currentPager) {
		return iAuthorDetailsDao.getAuthortListByPager(currentPager,Contents.Pager.DEF_PERPAGER_SIZE);
	}
	

}
