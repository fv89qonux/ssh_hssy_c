/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.pro.model.Comment;
import com.my.pro.utils.Pager;
import com.my.pro.service.CommentService;
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

@Service("commentServiceImpl")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{
	 
	@Autowired
	private CommentDao commentDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Comment> findPager(Comment comment) {
		return commentDao.findPager(comment);
	}
	

	

}
