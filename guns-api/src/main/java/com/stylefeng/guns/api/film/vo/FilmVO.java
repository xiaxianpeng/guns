package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 5:46 下午
 */
@Data
public class FilmVO implements Serializable {

    private int filmNum;
    private List<FilmInfo> filmInfos;
}
