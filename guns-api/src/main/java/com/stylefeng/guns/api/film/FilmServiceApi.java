package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import java.util.List;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 7:47 下午
 */
public interface FilmServiceApi {

    /**
     * @return banners
     */
    BannerVO getBanners();

    /**
     * 热映电影
     */
    FilmVO getHotFilms(boolean isLimit, int nums);

    /**
     * 即将上映电影
     */
    FilmVO getSoonFilms(boolean isLimit, int nums);

    /**
     * @return 票房排行榜
     */
    List<FilmInfo> getBoxRanking();

    /**
     * @return 人气排行榜
     */
    List<FilmInfo> getExceptRanking();

    /**
     * @return top100
     */
    List<FilmInfo> getTop();
}
