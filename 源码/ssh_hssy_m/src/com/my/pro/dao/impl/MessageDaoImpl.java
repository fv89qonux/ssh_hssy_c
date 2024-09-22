package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Message;
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
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Message> findPager(Message message) {
		if(message.getId() !=null && !"".equals(message.getId() )){
	    	   String hql = "from Message";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +message.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Message where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
