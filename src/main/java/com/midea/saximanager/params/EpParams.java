package com.midea.saximanager.params;

import javax.validation.constraints.NotNull;

public class EpParams {
    @NotNull(message = "公司名称不能为空")
    private String csName;
    @NotNull(message = "联系人不能为空")
    private String csConperson;
    @NotNull(message = "手机号不能为空")
    private String csPhone;
    @NotNull(message = "注册资金不能为空")
    private String csRegisterMoney;
    @NotNull(message = "注册时间不能为空")
    private String csStime;
    @NotNull(message = "办公面积不能为空")
    private String csSqure;
    @NotNull(message = "人员数目不能为空")
    private String csPnum;
    @NotNull(message = "是否申报不能为空")
    private String csOffer;
    @NotNull(message = "详细地址不能为空")
    private String csAddressDetail;
    @NotNull(message = "省份不能为空")
    private String csPname;
    @NotNull(message = "城市不能为空")
    private String csCname;
    @NotNull(message = "地区不能为空")
    private String csCarea;
    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public String getCsConperson() {
        return csConperson;
    }

    public String getCsPname() {
        return csPname;
    }

    public void setCsPname(String csPname) {
        this.csPname = csPname;
    }

    public String getCsCname() {
        return csCname;
    }

    public void setCsCname(String csCname) {
        this.csCname = csCname;
    }

    public String getCsCarea() {
        return csCarea;
    }

    public void setCsCarea(String csCarea) {
        this.csCarea = csCarea;
    }

    public void setCsConperson(String csConperson) {
        this.csConperson = csConperson;
    }

    public String getCsPhone() {
        return csPhone;
    }

    public void setCsPhone(String csPhone) {
        this.csPhone = csPhone;
    }

    public String getCsRegisterMoney() {
        return csRegisterMoney;
    }

    public void setCsRegisterMoney(String csRegisterMoney) {
        this.csRegisterMoney = csRegisterMoney;
    }

    public String getCsStime() {
        return csStime;
    }

    public void setCsStime(String csStime) {
        this.csStime = csStime;
    }

    public String getCsSqure() {
        return csSqure;
    }

    public void setCsSqure(String csSqure) {
        this.csSqure = csSqure;
    }

    public String getCsPnum() {
        return csPnum;
    }

    public void setCsPnum(String csPnum) {
        this.csPnum = csPnum;
    }

    public String getCsOffer() {
        return csOffer;
    }

    public void setCsOffer(String csOffer) {
        this.csOffer = csOffer;
    }

    public String getCsAddressDetail() {
        return csAddressDetail;
    }

    public void setCsAddressDetail(String csAddressDetail) {
        this.csAddressDetail = csAddressDetail;
    }
}
