package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 10:25 下午
 */
@Data
public class HallInfoVO implements Serializable {

    private String hallFieldId;
    private String hallName;
    private String price;
    private String seatFile;
    private String soldSeats;
}
