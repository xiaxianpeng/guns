package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:44 下午
 */
@Data
public class BrandVO implements Serializable {

    private String brandId;
    private String brandName;
    private Boolean isActive;
}
