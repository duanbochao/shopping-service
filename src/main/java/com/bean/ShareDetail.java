package com.bean;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 14:28
 */
public class ShareDetail {
    private Integer id;
    private String surl;
    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
