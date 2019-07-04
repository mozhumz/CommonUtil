package com.hyj.util.web;

import com.hyj.util.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuanjia
 */
@RestController
@Api(value = "测试相关接口", description = "测试相关接口")
@RequestMapping("/api/demo")
public class TestController {
    @Resource
    private HttpServletRequest request;




    @ApiOperation(value = "test")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object testAdd() {
        throw new BaseException(10005,"登陆失效");

    }



}
