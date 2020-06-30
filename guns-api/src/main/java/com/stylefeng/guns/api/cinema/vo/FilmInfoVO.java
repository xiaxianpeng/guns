package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:49 下午
 */
@Data
public class FilmInfoVO implements Serializable {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;

    List<FilmFieldVO> filmFields;
}
