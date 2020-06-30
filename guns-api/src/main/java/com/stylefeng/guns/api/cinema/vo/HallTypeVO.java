package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:46 下午
 */
@Data
public class HallTypeVO implements Serializable {

    private String hallTypeId;
    private String hallTypeName;
    private Boolean isActive;
}
