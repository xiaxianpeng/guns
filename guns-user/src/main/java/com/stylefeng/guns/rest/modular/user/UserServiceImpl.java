package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserApi;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xianpeng.xia
 * on 2019-09-06 01:15
 */
@Component
@Service(interfaceClass = UserApi.class)
public class UserServiceImpl implements UserApi {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(String username, String password) {
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        // TODO better: md5 混淆加密
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        user.setPassword(md5Password);
        user.setEmail(userModel.getEmail());
        user.setAddress(userModel.getAddress());
        user.setPhone(userModel.getPhone());
        Integer insert = userMapper.insert(user);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel) {
        return null;
    }
}
