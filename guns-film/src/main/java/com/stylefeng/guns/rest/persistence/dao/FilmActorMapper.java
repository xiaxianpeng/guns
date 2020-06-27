package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.rest.persistence.model.FilmActor;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片演员表 Mapper 接口
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-28
 */
public interface FilmActorMapper extends BaseMapper<FilmActor> {

    List<ActorVO> getActors(@Param("filmId") String filmId);
}
