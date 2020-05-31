package com.midea.saximanager.params;

import java.io.Serializable;

public class UserParams implements Serializable {

    private static final long serialVersionUID = 1766269363340148513L;

    private Integer page=1;

    private Integer page_len=20;

    private String name;

    private String pwd;

    public UserParams(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserParams(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage_len() {
        return page_len;
    }

    public void setPage_len(Integer page_len) {
        this.page_len = page_len;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
