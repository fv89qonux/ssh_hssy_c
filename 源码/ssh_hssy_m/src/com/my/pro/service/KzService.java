package com.my.pro.service;

import com.my.pro.model.Kz;
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
public interface KzService extends BaseService<Kz>{

	/**
	 * dao层分页查询
	 */
	Pager<Kz> findPager(Kz kz);
}
