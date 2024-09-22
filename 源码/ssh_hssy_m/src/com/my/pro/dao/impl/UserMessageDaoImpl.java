package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.UserMessage;
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
public class UserMessageDaoImpl extends BaseDaoImpl<UserMessage> implements UserMessageDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<UserMessage> findPager(UserMessage userMessage) {
		if(userMessage.getId() !=null && !"".equals(userMessage.getId() )){
	    	   String hql = "from UserMessage";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +userMessage.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from UserMessage where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
