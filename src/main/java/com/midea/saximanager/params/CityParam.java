package com.midea.saximanager.params;

import javax.validation.constraints.NotNull;

public class CityParam {
    @NotNull(message = "城市父及编号不能为空")
    public String parentid;

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
