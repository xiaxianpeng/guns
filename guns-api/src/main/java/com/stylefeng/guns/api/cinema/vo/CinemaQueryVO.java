package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:27 下午
 */
@Data
public class CinemaQueryVO implements Serializable {

    private Integer brandId = 99;
    private Integer districtId = 99;
    private Integer hallType = 99;
    private Integer pageSize = 12;
    private Integer nowPage = 1;
}
