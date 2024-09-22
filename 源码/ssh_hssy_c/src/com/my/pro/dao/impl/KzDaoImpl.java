package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Kz;
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
public class KzDaoImpl extends BaseDaoImpl<Kz> implements KzDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Kz> findPager(Kz kz) {
		if(kz.getId() !=null && !"".equals(kz.getId() )){
	    	   String hql = "from Kz";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +kz.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Kz where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
