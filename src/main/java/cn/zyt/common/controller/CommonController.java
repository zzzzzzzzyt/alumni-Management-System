package cn.zyt.common.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class CommonController {
    @GetMapping("/login")
    public String hello() {
        return "login";
    }

    //跳转的页面会默认到main/resource/templates中找
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //跳转至欢迎页面
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

}
