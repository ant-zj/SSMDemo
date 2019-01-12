package com.chatRobot.dao.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.chatRobot.common.util.FastjsonUtils;
import com.chatRobot.common.util.JedisUtils;
import com.chatRobot.dao.IUserDao;
import com.chatRobot.model.User;
import com.google.common.base.Joiner;



@Repository
public class IUserDaoImp implements IUserDao {
	
	@Autowired
	private IUserDao userMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		
		        User user = null;
		        //生成key，格式可以根据业务自行修改，但是必须得唯一
		        String key = Joiner.on("_").join(Arrays.asList(id,id));

		        try {
		            //根据key获取从缓存中获取到value
		            String value = JedisUtils.getInstance().get(key);
		            //判断是否为空
		            if (!StringUtils.isBlank(value)) {
		                return JSON.parseObject(value, User.class);
		            }
		            user = userMapper.selectByPrimaryKey(id);
		            //为空到情况下先从mysql查询数据，然后在set到redis中
		            JedisUtils.getInstance().set(key, FastjsonUtils.toJSONString(user));
		            //设置key的时效，时间以s为单位
		            //JedisUtils.getInstance().expire(key, 10);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return user;
		    }
	

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
