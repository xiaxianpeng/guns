package com.stylefeng.guns.api.film.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2020/6/28 12:30 上午
 */
@Data
public class ActorRequestVO implements Serializable {

    private ActorVO director;
    private List<ActorVO> actors;
}
