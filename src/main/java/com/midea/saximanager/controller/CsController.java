package com.midea.saximanager.controller;

import com.midea.saximanager.annotation.AopLog;
import com.midea.saximanager.annotation.RateLimit;
import com.midea.saximanager.model.TbArea;
import com.midea.saximanager.params.CityParam;
import com.midea.saximanager.params.EpParams;
import com.midea.saximanager.response.BaseResponseView;
import com.midea.saximanager.service.CsEnterPriseService;
import com.midea.saximanager.service.TbAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CsController {

    @Autowired
    TbAreaService tbAreaService;
    @Autowired
    CsEnterPriseService csEnterPriseService;

    @CrossOrigin
    @PostMapping(value = "/getcity")
    @ResponseBody
    @AopLog
    @RateLimit
    public BaseResponseView getcity(@Valid CityParam cityParam, BindingResult result, Model model, HttpServletRequest request){
        BaseResponseView baseResponseView=new BaseResponseView();
        model.addAttribute(cityParam);
        if(result.hasErrors()){
            baseResponseView.setMsg(result.getFieldError().getDefaultMessage());
            baseResponseView.setCode("-1");
            return baseResponseView;
        }
        List<TbArea> tbAreas=tbAreaService.getAreaList(Integer.parseInt(cityParam.getParentid()));
        baseResponseView.setData(tbAreas);
        return baseResponseView;
    }

    @CrossOrigin
    @PostMapping(value = "/addCsEp")
    @ResponseBody
    @AopLog
    @RateLimit
    public BaseResponseView addCsEp(@Valid EpParams epParams, BindingResult result, Model model, HttpServletRequest request){
        BaseResponseView baseResponseView=new BaseResponseView();
        model.addAttribute(epParams);
        if(result.hasErrors()){
            baseResponseView.setMsg(result.getFieldError().getDefaultMessage());
            baseResponseView.setCode("-1");
            return baseResponseView;
        }
        boolean flag=csEnterPriseService.addEp(epParams);
        if(flag==false){
            baseResponseView.setCode("-1");
            baseResponseView.setData("企业已存在！");
            return baseResponseView;
        }
        baseResponseView.setData("添加成功！");
        return baseResponseView;
    }
}
