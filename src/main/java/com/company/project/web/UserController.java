package com.company.project.web;
import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.interfaces.Claim;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.utils.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2021/03/23.
*/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size,
                       User user) {
        log.info("进入查询列表");
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        if(user != null && !StringUtils.isEmpty(user.getToken())){
            log.info("解密token");
            Map<String, Claim> map = JWTUtil.verifyToken(user.getToken());
            for (Map.Entry<String, Claim> entry : map.entrySet()) {
                 System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            }
            log.info("解密结束");
            log.info("通过token获取用户id");
            Long appUID = JWTUtil.getAppUID(user.getToken());
            log.info("当前登录的用户id是："+appUID.toString());
        }
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     *
     * @param user  account password
     * @return
     */
    @RequestMapping("/login")
    public Result UserLogin(User user){
        if (user == null || user.getAccount() == null || user.getPassword() == null) {
            return ResultGenerator.genFailResult("参数遗漏");
        }
        User userLogin = userService.userLogin(user);
        if (userLogin != null) {
            log.info("{}登录成功",userLogin.getNickname());
            log.info("开始生成jwt-----");
            try {
                String token = JWTUtil.createToken(Long.valueOf(userLogin.getId().toString()));
                log.info("生成的token是："+token);
                userLogin.setToken(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ResultGenerator.genSuccessResult(userLogin);
        }else {
            return ResultGenerator.genFailResult("账号密码错误");
        }
    }
}
