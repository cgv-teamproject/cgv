package com.qfedu.cgv.controller;

import com.qfedu.cgv.comment.vo.ResultVo;
import com.qfedu.cgv.service.MessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 冯志立
 * Date: 2019/3/11
 * Time: 17:43
 * Description: No Description
 */
@RestController
@CrossOrigin
public class MessageTypeController {
    @Autowired
    private MessageTypeService typeService;

    @GetMapping("messageTypeList.do")
    public ResultVo findAll(){
        return typeService.findAll();
    }
}
