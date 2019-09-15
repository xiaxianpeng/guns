package com.stylefeng.guns.rest.modular.film.vo;

import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 5:47 下午
 */
@Data
public class FilmInfo {

    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;
}
