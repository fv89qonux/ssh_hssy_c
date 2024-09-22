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
import com.my.pro.model.Yp;
import com.my.pro.utils.Pager;
import com.my.pro.service.YpService;
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

@Service("ypServiceImpl")
public class YpServiceImpl extends BaseServiceImpl<Yp> implements YpService{
	 
	@Autowired
	private YpDao ypDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Yp> findPager(Yp yp) {
		return ypDao.findPager(yp);
	}
	

	

}
