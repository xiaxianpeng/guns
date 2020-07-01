package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaServiceApi;
import com.stylefeng.guns.api.cinema.vo.AreaVO;
import com.stylefeng.guns.api.cinema.vo.BrandVO;
import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.CinemaQueryVO;
import com.stylefeng.guns.api.cinema.vo.CinemaVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallTypeVO;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaFieldResponseVO;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaFieldsResponseVO;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemalConditionResponseVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 9:22 下午
 */
@RestController
@RequestMapping("/cinema/")
public class CinemaController {

    @Reference(interfaceClass = CinemaServiceApi.class, cache = "lru", check = false)
    private CinemaServiceApi cinemaServiceApi;
    private static final String img_pre = "www.baidu.com";

    @RequestMapping(value = "getCinema")
    public ResponseVO getCinema(CinemaQueryVO cinemaQueryVO) {
        try {
            Page<CinemaVO> cinemas = cinemaServiceApi.getCinemas(cinemaQueryVO);
            if (CollectionUtils.isEmpty(cinemas.getRecords())) {
                return ResponseVO.success("null");
            } else {
                return ResponseVO.success(cinemas);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.serviceFaild("exception");
        }
    }

    @RequestMapping(value = "getCondition")
    public ResponseVO getCondition(CinemaQueryVO cinemaQueryVO) {
        List<BrandVO> brands = cinemaServiceApi.getBrands(cinemaQueryVO.getBrandId());
        List<AreaVO> areas = cinemaServiceApi.getAreas(cinemaQueryVO.getDistrictId());
        List<HallTypeVO> hallTypes = cinemaServiceApi.getHallTypes(cinemaQueryVO.getHallType());

        CinemalConditionResponseVO cinemalConditionResponseVO = new CinemalConditionResponseVO();
        cinemalConditionResponseVO.setAreas(areas);
        cinemalConditionResponseVO.setBrands(brands);
        cinemalConditionResponseVO.setHallTypes(hallTypes);
        return ResponseVO.success(cinemalConditionResponseVO);
    }

    @RequestMapping(value = "getFields")
    public ResponseVO getFields(Integer cinemaId) {
        CinemaInfoVO cinemaInfoById = cinemaServiceApi.getCinemaInfoById(cinemaId);
        List<FilmInfoVO> filmInfoByCinemaId = cinemaServiceApi.getFilmInfoByCinemaId(cinemaId);

        CinemaFieldsResponseVO responseVO = new CinemaFieldsResponseVO();
        responseVO.setFilmInfos(filmInfoByCinemaId);
        responseVO.setCinemaInfo(cinemaInfoById);
        return ResponseVO.success(img_pre, responseVO);
    }

    @RequestMapping(value = "getFieldInfo", method = RequestMethod.POST)
    public ResponseVO getFieldInfo(Integer cinemaId, Integer fieldId) {
        CinemaInfoVO cinemaInfoById = cinemaServiceApi.getCinemaInfoById(cinemaId);
        FilmInfoVO filmInfoByFieldId = cinemaServiceApi.getFilmInfoByFieldId(fieldId);
        HallInfoVO filmFieldInfo = cinemaServiceApi.getFilmFieldInfo(fieldId);

        CinemaFieldResponseVO responseVO = new CinemaFieldResponseVO();
        responseVO.setCinemaInfoById(cinemaInfoById);
        responseVO.setFilmFieldInfo(filmFieldInfo);
        responseVO.setFilmInfoByFieldId(filmInfoByFieldId);
        return ResponseVO.success(responseVO);
    }
}
