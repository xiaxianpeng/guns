package com.stylefeng.guns.api.cinema;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.vo.AreaVO;
import com.stylefeng.guns.api.cinema.vo.BrandVO;
import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.CinemaQueryVO;
import com.stylefeng.guns.api.cinema.vo.CinemaVO;
import com.stylefeng.guns.api.cinema.vo.FilmFieldVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallTypeVO;
import java.util.List;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:27 下午
 */
public interface CinemaServiceApi {

    // 根据CinemaQueryVO，查询影院列表
    Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO);

    // 根据条件获取品牌列表
    List<BrandVO> getBrands(int brandId);

    // 获取行政区域列表
    List<AreaVO> getAreas(int areaId);

    // 获取影厅类型列表
    List<HallTypeVO> getHallTypes(int hallType);

    // 根据影院编号，获取影院信息
    CinemaInfoVO getCinemaInfoById(int cinemaId);

    // 获取所有电影的信息和对应的放映场次信息，根据影院编号
    FilmInfoVO getFilmInfoByCinemaId(int cinemaId);

    // 根据放映场次ID获取放映信息
    FilmFieldVO getFilmFieldInfo(int fieldId);

    // 根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
    FilmInfoVO getFilmInfoByFieldId(int fieldId);

}
