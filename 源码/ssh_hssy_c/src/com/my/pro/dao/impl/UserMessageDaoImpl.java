package com.my.pro.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.pro.base.impl.BaseDaoImpl;
import com.my.pro.dao.UserMessageDao;
import com.my.pro.model.UserMessage;
@Repository
@SuppressWarnings("unchecked")
public class UserMessageDaoImpl extends BaseDaoImpl<UserMessage> implements UserMessageDao{

	@Override
	public List<UserMessage> findMessageJIluList(int userId) {
		String hql ="from UserMessage where resivrUser.id = :userId";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("userId", userId);
		return listByAlias(hql, alias);
	}

	@Override
	public List<UserMessage> findMessage(int userId) {
		String hql ="from UserMessage where resivrUser.id = :userId and isRead = 2";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("userId", userId);
		return listByAlias(hql, alias);
	}

}
