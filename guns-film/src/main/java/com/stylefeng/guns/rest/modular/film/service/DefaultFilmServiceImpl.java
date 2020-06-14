package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.CatVO;
import com.stylefeng.guns.api.film.vo.FilmDetailVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import com.stylefeng.guns.api.film.vo.SourceVO;
import com.stylefeng.guns.api.film.vo.YearVO;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.persistence.dao.BannerMapper;
import com.stylefeng.guns.rest.persistence.dao.CatDictMapper;
import com.stylefeng.guns.rest.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.persistence.dao.SourceDictMapper;
import com.stylefeng.guns.rest.persistence.dao.YearDictMapper;
import com.stylefeng.guns.rest.persistence.model.Banner;
import com.stylefeng.guns.rest.persistence.model.CatDict;
import com.stylefeng.guns.rest.persistence.model.Film;
import com.stylefeng.guns.rest.persistence.model.SourceDict;
import com.stylefeng.guns.rest.persistence.model.YearDict;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 8:29 下午
 */
@Service(interfaceClass = FilmServiceApi.class)
@Component
public class DefaultFilmServiceImpl implements FilmServiceApi {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private CatDictMapper catDictMapper;
    @Autowired
    private SourceDictMapper sourceDictMapper;
    @Autowired
    private YearDictMapper yearDictMapper;

    @Override
    public List<BannerVO> getBanners() {
        List<Banner> banners = bannerMapper.selectList(null);
        List<BannerVO> list = new ArrayList<>();
        for (Banner banner : banners) {
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerId(banner.getUuid() + "");
            bannerVO.setBannerUrl(banner.getBannerUrl());
            bannerVO.setBannerAddress(banner.getBannerAddress());
            list.add(bannerVO);
        }
        return list;
    }

    private List<FilmInfo> getFilmInfos(List<Film> films) {
        List<FilmInfo> filmInfos = new ArrayList<>();
        for (Film film : films) {
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setScore(film.getFilmScore());
            filmInfo.setImgAddress(film.getImgAddress());
            filmInfo.setFilmType(film.getFilmType());
            filmInfo.setFilmScore(film.getFilmScore());
            filmInfo.setFilmName(film.getFilmName());
            filmInfo.setFilmId(film.getUuid() + "");
            filmInfo.setExpectNum(film.getFilmPresalenum());
            filmInfo.setBoxNum(film.getFilmBoxOffice());
            filmInfo.setShowTime(DateUtil.getDay(film.getFilmTime()));
            filmInfos.add(filmInfo);
        }
        return filmInfos;
    }

    private FilmVO getFilms(int filmStatus, boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<Film> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", filmStatus);
        // 是否首页展示
        if (isLimit) {
            Page<Film> page = new Page<>(1, nums);
            List<Film> films = filmMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
        } else {
            // 1 按热门搜索 2 按时间搜索 3 按评价搜索
            String orderField = "film_time";
            switch (sortId) {
                case 1:
                    switch (filmStatus) {
                        case 1:
                            orderField = "film_box_office";
                            break;
                        case 2:
                            orderField = "film_preSaleNum";
                            break;
                        case 3:
                            orderField = "film_box_office";
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    orderField = "film_time";
                    break;
                case 3:
                    switch (filmStatus) {
                        case 1:
                            orderField = "film_box_office";
                            break;
                        case 2:
                            orderField = "film_preSaleNum";
                            break;
                        case 3:
                            orderField = "film_score";
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            Page<Film> page = new Page<>(nowPage, nums, orderField);

            if (sourceId != 99) {
                entityWrapper.eq("film_source", sourceId);
            }
            if (yearId != 99) {
                entityWrapper.eq("film_date", yearId);
            }
            if (catId != 99) {
                // #2#4#22#
                String catStr = "%#" + catId + "#%";
                entityWrapper.like("film_cats", catStr);
            }
            List<Film> films = filmMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
            // totalPage = totalCount / nums + 1
            int totalCounts = filmMapper.selectCount(entityWrapper);
            int totalPage = (totalCounts % nums) == 0 ? (totalCounts / nums) : (totalCounts / nums) + 1;
            filmVO.setTotalPage(totalPage);
            filmVO.setNowPage(nowPage);
        }
        filmVO.setFilmInfos(filmInfos);
        return filmVO;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return getFilms(1, isLimit, nums, nowPage, sortId, sourceId, yearId, catId);
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return getFilms(2, isLimit, nums, nowPage, sortId, sourceId, yearId, catId);
    }

    @Override
    public FilmVO getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return getFilms(3, false, nums, nowPage, sortId, sourceId, yearId, catId);
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_status", 1);
        Page<Film> page = new Page<>(1, 10, "film_box_office");
        List films = filmMapper.selectPage(page, entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(films);
        return filmInfos;
    }

    @Override
    public List<FilmInfo> getExceptRanking() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_status", 2);
        Page<Film> page = new Page<>(1, 10, "film_preSaleNum");
        List films = filmMapper.selectPage(page, entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(films);
        return filmInfos;
    }

    @Override
    public List<FilmInfo> getTop() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_status", 2);
        Page<Film> page = new Page<>(1, 10, "film_score");
        List films = filmMapper.selectPage(page, entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(films);
        return filmInfos;
    }

    @Override
    public List<CatVO> getCats() {
        List<CatDict> catDicts = catDictMapper.selectList(null);
        List<CatVO> catVOs = new ArrayList<>();
        for (CatDict catDict : catDicts) {
            CatVO catVO = new CatVO();
            catVO.setCatId(catDict.getUuid() + "");
            catVO.setCatName(catDict.getShowName());
            catVOs.add(catVO);
        }
        return catVOs;
    }

    @Override
    public List<SourceVO> getSources() {
        List<SourceDict> sourceDicts = sourceDictMapper.selectList(null);
        List<SourceVO> sourceVOs = new ArrayList<>();
        for (SourceDict sourceDict : sourceDicts) {
            SourceVO sourceVO = new SourceVO();
            sourceVO.setSourceId(sourceDict.getUuid() + "");
            sourceVO.setSourceName(sourceDict.getShowName());
            sourceVOs.add(sourceVO);
        }
        return sourceVOs;
    }

    @Override
    public List<YearVO> getYears() {
        List<YearDict> yearDicts = yearDictMapper.selectList(null);
        List<YearVO> yearVOs = new ArrayList<>();
        for (YearDict yearDict : yearDicts) {
            YearVO yearVO = new YearVO();
            yearVO.setYearId(yearDict.getUuid() + "");
            yearVO.setYearName(yearDict.getShowName());
            yearVOs.add(yearVO);
        }
        return yearVOs;
    }

    @Override
    public FilmDetailVO getFilmDetail(int searchType, String searchParam) {
        // searchType : 1 按名称 2 按
        return null;
    }
}
