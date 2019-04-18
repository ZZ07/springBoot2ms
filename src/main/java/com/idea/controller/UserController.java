package com.idea.controller;

import com.idea.controller.base.BaseController;
import com.idea.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Program: UserController
 * @Description: 用户控制器
 * @Author: Mr.Zhao
 * @Create: 2019-04-17 18:27
 **/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 添加用户
     *
     * @param mUserJson
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody String mUserJson) throws Exception {
        String resultInfo = "";
        try {
            resultInfo = userService.addUser(mUserJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 通过用户名称获取用户
     *
     * @param userName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserByName(@PathVariable String userName) throws Exception {
        String resultInfo = "";
        try {
            resultInfo = userService.getUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 修改用户
     *
     * @param mUserJson
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@PathVariable("id") String id, @RequestBody String mUserJson) throws Exception {
        String resultInfo = "";
        try {
            resultInfo = userService.updateUser(id, mUserJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id) throws Exception {
        String resultInfo = "";
        try {
            resultInfo = userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInfo;
    }
}
