package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.api.user.UserInfoModel;

/**
 * Created by xianpeng.xia
 * on 2019-09-10 23:38
 */
public class CurrentUser {

    // 线程绑定的存储空间
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserId(String userId) {
        threadLocal.set(userId);
    }

    public static String getCurrentUser() {
        return threadLocal.get();
    }
   /* public static void saveUserInfo(UserInfoModel userInfoModel) {
        threadLocal.set(userInfoModel);
    }

    public static UserInfoModel getCurrentUser() {
        return threadLocal.get();
    }*/

}
