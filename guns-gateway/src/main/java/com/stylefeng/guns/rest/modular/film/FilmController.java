package com.stylefeng.guns.rest.modular.film;

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

    @GetMapping("getIndex")
    public ResponseVO getIndex() {
        return null;
    }
}
