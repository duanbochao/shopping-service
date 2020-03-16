package com.bean;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/9 10:07
 */
public class RespBean {
    private Integer state;
    private Object message;



    public static RespBean success(Object message) {
       return new RespBean(200,message);
    }

    public static RespBean err(Object message) {
       return new RespBean(500,message);
    }


    public RespBean(Integer state, Object message) {
        this.state = state;
        this.message = message;
    }

    public RespBean(Object message) {
        this.message = message;
    }

    //成功
    public static RespBean ok(Object message) {
       return  new RespBean(1,message);
    }


    //失败
    public static RespBean error(Object message) {
        return  new RespBean(0,message);
    }

    public RespBean() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
