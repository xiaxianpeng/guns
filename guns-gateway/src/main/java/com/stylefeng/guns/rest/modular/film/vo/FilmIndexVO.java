package com.stylefeng.guns.rest.modular.film.vo;

import java.util.List;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 5:22 下午
 */
@Data
public class FilmIndexVO {

    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;
}
