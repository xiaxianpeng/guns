package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:45 下午
 */
@Data
public class AreaVO  implements Serializable {

    private String areaId;
    private String areaName;
    private Boolean isActive;
}
