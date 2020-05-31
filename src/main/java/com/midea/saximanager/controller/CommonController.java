package com.midea.saximanager.controller;

import com.midea.saximanager.annotation.AopLog;
import com.midea.saximanager.annotation.RateLimit;
import com.midea.saximanager.params.CommonParams;
import com.midea.saximanager.response.BaseResponseView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CommonController {

    @CrossOrigin
    @PostMapping(value = "sendPushMsg")
    @ResponseBody
    @AopLog
    @RateLimit
    public BaseResponseView sendPushMsg(@Valid CommonParams commonParams, BindingResult result, Model model, HttpServletRequest request){
        BaseResponseView baseResponseView=new BaseResponseView();
        model.addAttribute(commonParams);
        if(result.hasErrors()){
            baseResponseView.setMsg(result.getFieldError().getDefaultMessage());
            baseResponseView.setCode("-1");
            return baseResponseView;
        }
//        AliMessage aliMessage=new AliMessage(commonParams.getDeviceid(),commonParams.getContent());
//        MsgConsummer.sendMsg(aliMessage);
        return baseResponseView;
    }
}
