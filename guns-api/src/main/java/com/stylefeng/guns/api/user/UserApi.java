package com.stylefeng.guns.api.user;

/**
 * Created by xianpeng.xia
 * on 2019-09-06 01:14
 */
public interface UserApi {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel);
}
