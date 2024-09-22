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
import com.my.pro.model.UserMessage;
import com.my.pro.utils.Pager;
import com.my.pro.service.UserMessageService;
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

@Service("userMessageServiceImpl")
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage> implements UserMessageService{
	 
	@Autowired
	private UserMessageDao userMessageDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<UserMessage> findPager(UserMessage userMessage) {
		return userMessageDao.findPager(userMessage);
	}
	

	

}
