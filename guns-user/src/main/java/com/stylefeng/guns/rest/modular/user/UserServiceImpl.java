package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserApi;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.persistence.model.User;
import java.util.Date;
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
        User user = new User();
        user.setUsername(username);
        User userDb = userMapper.selectOne(user);
        if (userDb != null && userDb.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (md5Password.equals(userDb.getPassword())) {
                return userDb.getUuid();
            }
        }
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
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        userEntityWrapper.eq("username", username);
        Integer count = userMapper.selectCount(userEntityWrapper);
        if (count != null && count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        User user = userMapper.selectById(uuid);
        UserInfoModel userInfoModel = do2UserInfo(user);
        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel) {
        User user = new User();
        user.setUuid(userInfoModel.getUuid());
        user.setNickName(userInfoModel.getNickName());
        user.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        user.setBirthday(userInfoModel.getBirthday());
        user.setBiography(userInfoModel.getBiography());
        user.setBeginTime(time2Date(userInfoModel.getBeginTime()));
        user.setHeadUrl(userInfoModel.getHeadAddress());
        user.setEmail(userInfoModel.getEmail());
        user.setAddress(userInfoModel.getAddress());
        user.setPhone(userInfoModel.getPhone());
        user.setSex(userInfoModel.getSex());
        user.setUpdateTime(time2Date(System.currentTimeMillis()));
        Integer update = userMapper.updateById(user);
        if (update > 0) {
            return getUserInfo(user.getUuid());
        }
        return userInfoModel;
    }

    private UserInfoModel do2UserInfo(User user) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUsername(user.getUsername());
        userInfoModel.setAddress(user.getAddress());
        userInfoModel.setBeginTime(user.getBeginTime().getTime());
        userInfoModel.setUpdateTime(user.getUpdateTime().getTime());
        userInfoModel.setNickName(user.getNickName());
        userInfoModel.setPhone(user.getPhone());
        userInfoModel.setBiography(user.getBiography());
        userInfoModel.setBirthday(user.getBirthday());
        userInfoModel.setEmail(user.getEmail());
        userInfoModel.setHeadAddress(user.getHeadUrl());
        userInfoModel.setLifeState(user.getLifeState() + "");
        userInfoModel.setSex(user.getSex());
        return userInfoModel;
    }

    private Date time2Date(long time) {
        return new Date(time);
    }
}
