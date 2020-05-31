package com.midea.saximanager.params;

import com.midea.saximanager.params.baseparams.BaseParams;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CommonParams extends BaseParams implements Serializable {
    private static final long serialVersionUID = 6238315877637824921L;
    @NotNull(message = "设备号不能为空")
    public String deviceid;
    @NotNull(message = "内容不能为空")
    public String content;

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
