package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.persistence.dao.BannerMapper;
import com.stylefeng.guns.rest.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.persistence.model.Banner;
import com.stylefeng.guns.rest.persistence.model.Film;
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

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<Film> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", 1);
        if (isLimit) {
            Page<Film> page = new Page<>(1, nums);
            List<Film> films = filmMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
        } else {

        }
        filmVO.setFilmInfos(filmInfos);
        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<Film> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", 2);
        if (isLimit) {
            Page<Film> page = new Page<>(1, nums);
            List<Film> films = filmMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
        } else {

        }
        filmVO.setFilmInfos(filmInfos);
        return filmVO;
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
}
