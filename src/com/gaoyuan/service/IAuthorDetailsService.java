package com.gaoyuan.service;

import java.util.List;

import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Blog;
import com.gaoyuan.bean.Expert;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午6:21:23
 * @details 
 */
public interface IAuthorDetailsService {

	boolean saveAuthorDetails(Author author);

	boolean saveBlog(Blog blog);
	
	List<Expert> getExpertListByPager(int currentPager,int pagerSize);
	List<Expert> getExpertListByPager(int currentPager);
	
	List<Author> getAuthorListByPager(int currentPager,int pagerSize);
	List<Author> getAuthorListByPager(int currentPager);

}
