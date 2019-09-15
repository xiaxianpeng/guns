package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.CatVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import com.stylefeng.guns.api.film.vo.SourceVO;
import com.stylefeng.guns.api.film.vo.YearVO;
import java.util.List;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 7:47 下午
 */
public interface FilmServiceApi {

    /**
     * @return banners
     */
    List<BannerVO> getBanners();

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

    /**
     * 分类条件
     */
    List<CatVO> getCats();

    /**
     * 片源条件
     */
    List<SourceVO> getSources();

    /**
     * 年代条件
     */
    List<YearVO> getYears();
}
