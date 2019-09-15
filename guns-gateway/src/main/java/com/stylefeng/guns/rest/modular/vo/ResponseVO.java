package com.stylefeng.guns.rest.modular.vo;

import lombok.Data;

/**
 * Created by xianpeng.xia
 * on 2019-09-10 08:34
 */
@Data
public class ResponseVO<M> {

    /**
     * 1:success,0:failed,3:error
     */
    private int status;
    private String msg;
    private M data;
    private String imgPre;

    private ResponseVO() {
    }

    public static <M> ResponseVO success(M m) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg("success");
        responseVO.setData(m);
        return responseVO;
    }

    public static <M> ResponseVO success(String imgPre, M m) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg("success");
        responseVO.setData(m);
        responseVO.setImgPre(imgPre);
        return responseVO;
    }

    public static <M> ResponseVO success(String message) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(message);
        return responseVO;
    }

    public static <M> ResponseVO serviceFaild(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMsg(msg);
        responseVO.setStatus(0);
        return responseVO;
    }

    public static <M> ResponseVO appFaild(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(3);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }
}
