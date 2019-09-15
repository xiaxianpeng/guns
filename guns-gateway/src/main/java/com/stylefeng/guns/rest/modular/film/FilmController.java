package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 5:12 下午
 */
@RestController
@RequestMapping("/film/")
public class FilmController {

    private static final String IMG_PRE = "www.baidu.com/";
    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    @GetMapping("getIndex")
    public ResponseVO getIndex() {
        FilmIndexVO filmIndexVO = new FilmIndexVO();
        filmIndexVO.setBanners(filmServiceApi.getBanners());
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true, 8));
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true, 8));
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());
        filmIndexVO.setExpectRanking(filmServiceApi.getExceptRanking());
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(IMG_PRE, filmIndexVO);
    }
}
