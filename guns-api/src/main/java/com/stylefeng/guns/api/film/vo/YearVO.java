package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 9:40 下午
 */
@Data
public class YearVO implements Serializable {

    private String yearId;
    private String yearName;
    private boolean isActive;
}
