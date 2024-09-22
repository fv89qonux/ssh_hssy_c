package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Yp;
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
public class YpDaoImpl extends BaseDaoImpl<Yp> implements YpDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Yp> findPager(Yp yp) {
		if(yp.getId() !=null && !"".equals(yp.getId() )){
	    	   String hql = "from Yp";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +yp.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Yp where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
