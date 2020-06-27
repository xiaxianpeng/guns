package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.film.FilmAsyncServiceApi;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.api.film.vo.FilmDescVO;
import com.stylefeng.guns.api.film.vo.ImgVO;
import com.stylefeng.guns.rest.persistence.dao.ActorMapper;
import com.stylefeng.guns.rest.persistence.dao.FilmActorMapper;
import com.stylefeng.guns.rest.persistence.dao.FilmInfoMapper;
import com.stylefeng.guns.rest.persistence.model.Actor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xianpeng.xia
 * on 2019/9/15 8:29 下午
 */
@Service(interfaceClass = FilmServiceApi.class)
@Component
public class DefaultFilmAsyncServiceImpl implements FilmAsyncServiceApi {

    @Autowired
    private ActorMapper actorMapper;

    @Autowired
    private FilmInfoMapper filmInfoMapper;

    @Autowired
    private FilmActorMapper filmActorMapper;


    private com.stylefeng.guns.rest.persistence.model.FilmInfo getFilmInfo(String filmId) {
        com.stylefeng.guns.rest.persistence.model.FilmInfo filmInfo = new com.stylefeng.guns.rest.persistence.model.FilmInfo();
        filmInfo.setFilmId(filmId);
        filmInfoMapper.selectOne(filmInfo);
        return filmInfo;
    }

    @Override
    public FilmDescVO getFilmDesc(String filmId) {
        com.stylefeng.guns.rest.persistence.model.FilmInfo filmInfo = getFilmInfo(filmId);

        FilmDescVO filmDescVO = new FilmDescVO();
        filmDescVO.setBiography(filmInfo.getBiography());
        filmDescVO.setFilmId(filmId);

        return filmDescVO;
    }

    @Override
    public ImgVO getImgs(String filmId) {
        com.stylefeng.guns.rest.persistence.model.FilmInfo filmInfo = getFilmInfo(filmId);

        String filmImgsStr = filmInfo.getFilmImgs();

        String[] filmImgs = filmImgsStr.split(",");
        ImgVO imgVO = new ImgVO();
        imgVO.setMainImg(filmImgs[0]);
        imgVO.setImg01(filmImgs[1]);
        imgVO.setImg02(filmImgs[2]);
        imgVO.setImg03(filmImgs[3]);
        imgVO.setImg04(filmImgs[4]);
        return imgVO;
    }

    @Override
    public ActorVO getDictInfo(String filmId) {
        com.stylefeng.guns.rest.persistence.model.FilmInfo filmInfo = getFilmInfo(filmId);
        Integer directorId = filmInfo.getDirectorId();
        Actor actor = actorMapper.selectById(directorId);
        ActorVO actorVO = new ActorVO();
        actorVO.setImgAddress(actor.getActorImg());
        actorVO.setDirectorName(actor.getActorName());
        return actorVO;
    }

    @Override
    public List<ActorVO> getActors(String filmId) {
        List<ActorVO> actors = filmActorMapper.getActors(filmId);
        return actors;
    }
}
