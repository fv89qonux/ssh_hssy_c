package com.my.pro.service;

import com.my.pro.model.UserMessage;
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
public interface UserMessageService extends BaseService<UserMessage>{

	/**
	 * dao层分页查询
	 */
	Pager<UserMessage> findPager(UserMessage userMessage);
}
