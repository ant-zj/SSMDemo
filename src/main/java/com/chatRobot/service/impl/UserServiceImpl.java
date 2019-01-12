package com.chatRobot.service.impl;

import com.chatRobot.dao.impl.IUserDaoImp;
import com.chatRobot.model.User;
import com.chatRobot.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDaoImp userDao;

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		User user =  userDao.selectByPrimaryKey(id);
		return user;
	 }
	}