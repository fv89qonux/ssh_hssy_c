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
import com.my.pro.model.Message;
import com.my.pro.utils.Pager;
import com.my.pro.service.MessageService;
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

@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService{
	 
	@Autowired
	private MessageDao messageDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Message> findPager(Message message) {
		return messageDao.findPager(message);
	}
	

	

}
