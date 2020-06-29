package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:51 下午
 */
@Data
public class FilmFieldVO implements Serializable {

    private String fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private String price;
}
