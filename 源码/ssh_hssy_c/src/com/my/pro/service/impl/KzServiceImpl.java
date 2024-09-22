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
import com.my.pro.model.Kz;
import com.my.pro.utils.Pager;
import com.my.pro.service.KzService;
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

@Service("kzServiceImpl")
public class KzServiceImpl extends BaseServiceImpl<Kz> implements KzService{
	 
	@Autowired
	private KzDao kzDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Kz> findPager(Kz kz) {
		return kzDao.findPager(kz);
	}
	

	

}
