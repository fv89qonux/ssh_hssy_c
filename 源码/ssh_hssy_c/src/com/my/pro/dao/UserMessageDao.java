package com.my.pro.dao;

import java.util.List;

import com.my.pro.base.BaseDao;
import com.my.pro.model.UserMessage;

public interface UserMessageDao extends BaseDao<UserMessage>{

	List<UserMessage> findMessageJIluList(int userId);

	List<UserMessage> findMessage(int userId);

}
