package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/28 12:32 上午
 */
@Data
public class InfoRequestVO implements Serializable {

    private String biography;
    private ActorRequestVO actors;
    private ImgVO img;
    private String filmId;
}
