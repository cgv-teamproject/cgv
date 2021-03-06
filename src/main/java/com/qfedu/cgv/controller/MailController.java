package com.qfedu.cgv.controller;

import com.qfedu.cgv.comment.utils.ResultUtil;
import com.qfedu.cgv.comment.vo.ResultVo;
import com.qfedu.cgv.service.impl.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: 冯志立
 * Date: 2019/3/9
 * Time: 13:53
 * Description: No Description
 */
@Api
@RestController
@CrossOrigin
public class MailController {
    @Autowired
    private MailService mailService;


    @ApiOperation(value = "邮箱验证码接口")
    @GetMapping("getCheckCode.do")
    public ResultVo getCheckCode(@ApiParam(name = "mail", value = "邮箱") String mail){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(mail, "注册验证码", message);
        }catch (Exception e){
            return ResultUtil.exec(false,null,null);
        }
        return ResultUtil.exec(true,checkCode,null);
    }
}
