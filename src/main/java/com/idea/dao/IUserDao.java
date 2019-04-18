package com.idea.dao;

import com.idea.model.MUser;

/**
 * @Program: IUserDao
 * @Description: User数据访问接口DAO
 * @Author: Mr.Zhao
 * @Create: 2019-04-17 18:29
 **/
public interface IUserDao {

    int countUserName(MUser mUser);

    boolean addUser(MUser mUser);

    MUser getUserByName(String userName);

    MUser getUserById(String id);

    boolean updateUser(MUser mUser);

    boolean deleteUser(String id);
}
