package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:47 下午
 */
@Data
public class CinemaInfoVO implements Serializable {

    private String cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaPhone;
}
