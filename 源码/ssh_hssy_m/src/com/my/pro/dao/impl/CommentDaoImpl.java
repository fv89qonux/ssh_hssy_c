package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Comment;
import com.my.pro.utils.Pager;
import com.my.pro.base.impl.BaseDaoImpl;
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

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Comment> findPager(Comment comment) {
		if(comment.getId() !=null && !"".equals(comment.getId() )){
	    	   String hql = "from Comment";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +comment.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Comment where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
