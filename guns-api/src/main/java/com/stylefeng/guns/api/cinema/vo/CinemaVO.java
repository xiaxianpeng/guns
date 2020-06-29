package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:43 下午
 */
@Data
public class CinemaVO implements Serializable {

    private String uuid;
    private String cinemaName;
    private String address;
    private String minimumPrice;

}
