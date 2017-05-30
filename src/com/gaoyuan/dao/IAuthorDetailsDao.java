package com.gaoyuan.dao;

import java.util.List;

import com.gaoyuan.bean.Author;
import com.gaoyuan.bean.Blog;
import com.gaoyuan.bean.Expert;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午5:41:38
 * @details 
 */
public interface IAuthorDetailsDao {

	boolean saveAuthorDetails(Author author);
	
	Author selectAuthor(String id_Author);

	Object selectBlog(String id_blog);

	boolean saveBlog(Blog blog);

	List<Expert> getExpertListByPager(int currentPager, int pagerSize);

	List<Author> getAuthortListByPager(int currentPager, int i);

	Expert selectExpert(String id_author);


}
