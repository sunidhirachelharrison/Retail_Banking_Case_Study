package com.tcs.ilp.dao;

import com.tcs.ilp.bean.UserModel;

public interface UserDao {
	UserModel findUserById(String  l_username);
}