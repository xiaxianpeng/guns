package com.stylefeng.guns.api.user.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019-09-09 00:10
 */
@Data
public class UserInfoModel implements Serializable {

    private String username;
    private String nickName;
    private String email;
    private String phone;
    private int sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private long beginTime;
    private long updateTime;
    private Integer uuid;

}
