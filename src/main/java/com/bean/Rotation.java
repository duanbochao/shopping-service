package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 11:09
 */
public class Rotation {

    private Integer id;
    private String img;
    private String url;
    private boolean enabled;

    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
