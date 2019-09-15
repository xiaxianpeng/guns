package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 9:38 下午
 */
@Data
public class CatVO implements Serializable {

    private String catId;
    private String catName;
    private boolean isActive;
}
