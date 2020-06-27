package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/27 11:30 下午
 */
@Data
public class ActorVO implements Serializable {

    private String imgAddress;
    private String directorName;
    private String roleName;
}
