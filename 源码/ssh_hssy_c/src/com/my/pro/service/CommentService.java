package com.my.pro.service;

import com.my.pro.model.Comment;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */
public interface CommentService extends BaseService<Comment>{

	/**
	 * dao层分页查询
	 */
	Pager<Comment> findPager(Comment comment);
}
