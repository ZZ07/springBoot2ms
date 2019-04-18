package com.idea.service;

import com.idea.dao.IUserDao;
import com.idea.model.MUser;
import com.idea.service.base.BaseService;
import com.idea.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Program: UserService
 * @Description: User业务逻辑层
 * @Author: Mr.Zhao
 * @Create: 2019-04-17 18:29
 **/
@Service("userService")
public class UserService extends BaseService {

    @Resource(name = "userDaoImpl")
    private IUserDao iUserDao;


    /**
     * 添加用户
     *
     * @param mUserJson
     * @return
     */
    public String addUser(String mUserJson) {
        Result br = new Result();
        MUser mUser = json.parseObject(mUserJson, MUser.class);
        int count = iUserDao.countUserName(mUser);
        if (count > 0) {
            br.setCode("400");
            br.setMsg("用户名已存在");
            return json.toJSONString(br);
        }
        mUser.setId(get32UUID());
        boolean result = iUserDao.addUser(mUser);
        if (result) {
            br.setCode("200");
            br.setMsg("注册成功");
            br.setData(mUser);
        } else {
            br.setCode("400");
            br.setMsg("注册失败");
        }
        return json.toJSONString(br);
    }

    /**
     * 通过用户名获取用户
     *
     * @param userName
     * @return
     */
    public String getUserByName(String userName) {
        Result br = new Result();
        MUser mUser = iUserDao.getUserByName(userName);
        br.setCode("200");
        br.setMsg("Ok");
        br.setData(mUser);
        return json.toJSONString(br);
    }

    /**
     * 编辑用户
     *
     * @param mUserJson
     * @return
     */
    public String updateUser(String id, String mUserJson) {
        Result br = new Result();
        MUser mUser = json.parseObject(mUserJson, MUser.class);
        MUser myMUser = iUserDao.getUserById(id);
        if (myMUser == null) {
            br.setCode("400");
            br.setMsg("用户不存在");
            return json.toJSONString(br);
        }
        boolean result = iUserDao.updateUser(mUser);
        if (result) {
            br.setCode("200");
            br.setMsg("修改成功");
        } else {
            br.setCode("400");
            br.setMsg("修改失败");
        }
        return json.toJSONString(br);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public String deleteUser(String id) {
        Result br = new Result();
        MUser myMUser = iUserDao.getUserById(id);
        if (myMUser == null) {
            br.setCode("400");
            br.setMsg("用户不存在");
            return json.toJSONString(br);
        }
        boolean result = iUserDao.deleteUser(id);
        if (result) {
            br.setCode("200");
            br.setMsg("删除成功");
        } else {
            br.setCode("400");
            br.setMsg("删除失败");
        }
        return json.toJSONString(br);
    }
}
