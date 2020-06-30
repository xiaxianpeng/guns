package com.stylefeng.guns.rest.persistence.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaServiceApi;
import com.stylefeng.guns.api.cinema.vo.AreaVO;
import com.stylefeng.guns.api.cinema.vo.BrandVO;
import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.CinemaQueryVO;
import com.stylefeng.guns.api.cinema.vo.CinemaVO;
import com.stylefeng.guns.api.cinema.vo.FilmFieldVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallTypeVO;
import com.stylefeng.guns.rest.persistence.dao.AreaDictMapper;
import com.stylefeng.guns.rest.persistence.dao.BrandDictMapper;
import com.stylefeng.guns.rest.persistence.dao.CinemaMapper;
import com.stylefeng.guns.rest.persistence.dao.FieldMapper;
import com.stylefeng.guns.rest.persistence.dao.HallDictMapper;
import com.stylefeng.guns.rest.persistence.dao.HallFilmInfoMapper;
import com.stylefeng.guns.rest.persistence.model.AreaDict;
import com.stylefeng.guns.rest.persistence.model.BrandDict;
import com.stylefeng.guns.rest.persistence.model.Cinema;
import com.stylefeng.guns.rest.persistence.model.Field;
import com.stylefeng.guns.rest.persistence.model.HallDict;
import com.stylefeng.guns.rest.persistence.model.HallFilmInfo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sun.lwawt.macosx.CImage;

/**
 * Created by xianpeng.xia
 * on 2020/6/29 11:05 下午
 */
public class DefaultCinemaServiceImpl implements CinemaServiceApi {

    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private BrandDictMapper brandDictMapper;
    @Autowired
    private AreaDictMapper areaDictMapper;
    @Autowired
    private HallDictMapper hallDictMapper;
    @Autowired
    private HallFilmInfoMapper hallFilmInfoMapper;

    @Override
    public Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO) {
        Page<Cinema> page = new Page<>(cinemaQueryVO.getNowPage(), cinemaQueryVO.getPageSize());
        EntityWrapper<Cinema> entityWrapper = new EntityWrapper<>();
        if (cinemaQueryVO.getBrandId() != 99) {
            entityWrapper.eq("brand_id", cinemaQueryVO.getBrandId());
        }
        if (cinemaQueryVO.getDistrictId() != 99) {
            entityWrapper.eq("area_id", cinemaQueryVO.getDistrictId());
        }
        if (cinemaQueryVO.getHallType() != 99) {
            entityWrapper.like("hall_ids", "%#+" + cinemaQueryVO.getHallType() + "+#%");
        }

        List<Cinema> cinemas = cinemaMapper.selectPage(page, entityWrapper);

        List<CinemaVO> cinemaVOS = new ArrayList<>();
        for (Cinema cinema : cinemas) {
            CinemaVO cinemaVO = new CinemaVO();
            cinemaVO.setUuid(cinema.getUuid() + "");
            cinemaVO.setMinimumPrice(cinema.getMinimumPrice() + "");
            cinemaVO.setCinemaName(cinema.getCinemaName());
            cinemaVO.setAddress(cinema.getCinemaAddress());
            cinemaVOS.add(cinemaVO);
        }
        Integer count = cinemaMapper.selectCount(entityWrapper);

        Page<CinemaVO> result = new Page<>();
        result.setRecords(cinemaVOS);
        result.setSize(cinemaQueryVO.getPageSize());
        result.setTotal(count);
        return result;
    }

    @Override
    public List<BrandVO> getBrands(int brandId) {
        boolean flag = false;
        BrandDict brandDict = brandDictMapper.selectById(brandId);
        if (brandId == 99 || brandDict == null || brandDict.getUuid() == null) {
            flag = true;
        }

        List<BrandDict> brandDicts = brandDictMapper.selectList(null);
        List<BrandVO> brandVOS = new ArrayList<>();
        for (BrandDict dict : brandDicts) {
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandId(dict.getUuid() + "");
            brandVO.setBrandName(dict.getShowName());

            if (flag) {
                if (dict.getUuid() == 99) {
                    brandVO.setIsActive(true);
                }
            } else {
                if (dict.getUuid() == brandId) {
                    brandVO.setIsActive(true);
                }
            }
            brandVOS.add(brandVO);
        }

        return brandVOS;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        boolean flag = false;
        AreaDict areaDict = areaDictMapper.selectById(areaId);
        if (areaId == 99 || areaDict == null || areaDict.getUuid() == null) {
            flag = true;
        }

        List<AreaDict> areaDicts = areaDictMapper.selectList(null);
        List<AreaVO> areaVOS = new ArrayList<>();
        for (AreaDict dict : areaDicts) {
            AreaVO areaVO = new AreaVO();
            areaVO.setAreaId(dict.getUuid() + "");
            areaVO.setAreaName(dict.getShowName());

            if (flag) {
                if (dict.getUuid() == 99) {
                    areaVO.setIsActive(true);
                }
            } else {
                if (dict.getUuid() == areaId) {
                    areaVO.setIsActive(true);
                }
            }
            areaVOS.add(areaVO);
        }

        return areaVOS;
    }

    @Override
    public List<HallTypeVO> getHallTypes(int hallType) {
        boolean flag = false;
        HallDict hallDict = hallDictMapper.selectById(hallType);
        if (hallType == 99 || hallDict == null || hallDict.getUuid() == null) {
            flag = true;
        }

        List<HallDict> hallDicts = hallDictMapper.selectList(null);
        List<HallTypeVO> hallTypeVOS = new ArrayList<>();
        for (HallDict dict : hallDicts) {
            HallTypeVO hallTypeVO = new HallTypeVO();
            hallTypeVO.setHallTypeId(dict.getUuid() + "");
            hallTypeVO.setHallTypeName(dict.getShowName());

            if (flag) {
                if (dict.getUuid() == 99) {
                    hallTypeVO.setIsActive(true);
                }
            } else {
                if (dict.getUuid() == hallType) {
                    hallTypeVO.setIsActive(true);
                }
            }
            hallTypeVOS.add(hallTypeVO);
        }

        return hallTypeVOS;
    }

    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId) {
        Cinema cinema = cinemaMapper.selectById(cinemaId);

        CinemaInfoVO cinemaInfoVO = new CinemaInfoVO();
        cinemaInfoVO.setCinemaAddress(cinema.getCinemaAddress());
        cinemaInfoVO.setCinemaId(cinema.getUuid() + "");
        cinemaInfoVO.setCinemaName(cinema.getCinemaName());
        cinemaInfoVO.setCinemaPhone(cinema.getCinemaPhone());
        cinemaInfoVO.setImgUrl(cinema.getImgAddress());

        return cinemaInfoVO;
    }

    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId) {
        List<FilmInfoVO> filmInfos = fieldMapper.getFilmInfos(cinemaId);
        return filmInfos;
    }

    @Override
    public HallInfoVO getFilmFieldInfo(int fieldId) {
        return fieldMapper.getHallInfo(fieldId);
    }

    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId) {

        return fieldMapper.getFilmInfoById(fieldId);
    }
}
