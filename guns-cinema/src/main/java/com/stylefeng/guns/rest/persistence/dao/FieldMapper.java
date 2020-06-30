package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.api.cinema.vo.FilmFieldVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVO;
import com.stylefeng.guns.rest.persistence.model.Field;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 放映场次信息表 Mapper 接口
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
public interface FieldMapper extends BaseMapper<Field> {

    List<FilmInfoVO> getFilmInfos(int cinemaId);

    HallInfoVO getHallInfo(int field);

    FilmInfoVO getFilmInfoById(int fieldId);
}
