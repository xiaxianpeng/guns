package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserApi;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianpeng.xia
 * on 2019-09-13 01:54
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Reference(interfaceClass = UserApi.class)
    UserApi userApi;

    @RequestMapping("register")
    public ResponseVO register(UserModel userModel) {
        if (userModel.getUsername() == null || userModel.getUsername().trim().length() == 0) {
            return ResponseVO.serviceFaild("username can't be null");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().length() == 0) {
            return ResponseVO.serviceFaild("password can't be null");
        }
        boolean success = userApi.register(userModel);
        if (success) {
            return ResponseVO.success("register success");
        } else {
            return ResponseVO.serviceFaild("register failed");
        }
    }

    @PostMapping("check")
    public ResponseVO check(String username) {
        if (username == null || username.trim().length() == 0) {
            return ResponseVO.serviceFaild("username can't be null");
        } else {
            boolean exist = userApi.checkUsername(username);
            if (exist) {
                return ResponseVO.serviceFaild("username already exists");
            } else {
                return ResponseVO.success("username not exist");
            }
        }
    }

    @GetMapping("logout")
    public ResponseVO logout() {
       /*
       应用：
        1 前端存储jwt（7天），jwt刷新
        2 服务器存储用户信息30分钟
        3 jwr的userId为key，查找活跃用户

       退出：
        1 前端少出jwt
        2 后端删除活跃用户缓存
        */
        return ResponseVO.success("logout success");
    }

    @GetMapping("getUserInfo")
    public ResponseVO getUserInfo() {
        String userId = CurrentUser.getCurrentUser();
        if (userId == null || userId.trim().length() == 0) {
            return ResponseVO.serviceFaild("user not logged in");
        } else {
            UserInfoModel userInfo = userApi.getUserInfo(Integer.parseInt(userId));
            if (userInfo != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.serviceFaild("get userInfo failed");
            }
        }
    }


    @PostMapping("updateUserInfo")
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {
        String userId = CurrentUser.getCurrentUser();
        if (userId != null && userId.trim().length() > 0) {
            int uuid = Integer.parseInt(userId);
            if (uuid != userInfoModel.getUuid()) {
                return ResponseVO.serviceFaild("plaease update your userInfo");
            }
            UserInfoModel userInfo = userApi.updateUserInfoModel(userInfoModel);
            if (userId != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.serviceFaild("update userInfo failed");
            }
        } else {
            return ResponseVO.serviceFaild("user not logged in");
        }
    }
}
