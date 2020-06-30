package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.AreaVO;
import com.stylefeng.guns.api.cinema.vo.BrandVO;
import com.stylefeng.guns.api.cinema.vo.HallTypeVO;
import java.util.List;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/7/1 12:11 上午
 */
@Data
public class CinemalConditionResponseVO {

    List<BrandVO> brands;
    List<AreaVO> areas;
    List<HallTypeVO> hallTypes;

}
