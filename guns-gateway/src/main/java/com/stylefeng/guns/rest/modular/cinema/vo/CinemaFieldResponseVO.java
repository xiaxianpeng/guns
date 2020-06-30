package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVO;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/7/1 12:35 上午
 */
@Data
public class CinemaFieldResponseVO {

    CinemaInfoVO cinemaInfoById;
    FilmInfoVO filmInfoByFieldId;
    HallInfoVO filmFieldInfo;

}
