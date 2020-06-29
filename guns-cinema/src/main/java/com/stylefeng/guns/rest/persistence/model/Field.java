package com.stylefeng.guns.rest.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 放映场次信息表
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-29
 */
public class Field extends Model<Field> {

    private static final long serialVersionUID = 1L;

    /**
     * pk
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 影院id
     */
    @TableField("cinema_id")
    private Integer cinemaId;
    /**
     * 电影id
     */
    @TableField("film_id")
    private Integer filmId;
    /**
     * 开始时间
     */
    @TableField("begin_time")
    private String beginTime;
    /**
     * 结束时间
     */
    @TableField("end_time")
    private String endTime;
    /**
     * 影厅id
     */
    @TableField("hall_id")
    private Integer hallId;
    /**
     * 影厅名
     */
    @TableField("hall_name")
    private String hallName;
    /**
     * 票价
     */
    private Integer price;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "Field{" +
        "uuid=" + uuid +
        ", cinemaId=" + cinemaId +
        ", filmId=" + filmId +
        ", beginTime=" + beginTime +
        ", endTime=" + endTime +
        ", hallId=" + hallId +
        ", hallName=" + hallName +
        ", price=" + price +
        "}";
    }
}
