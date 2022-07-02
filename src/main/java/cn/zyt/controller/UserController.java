package cn.zyt.controller;

import cn.zyt.common.vo.Result;
import cn.zyt.entity.User;
import cn.zyt.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(User param, @RequestParam("captcha") String captcha,
                        HttpServletRequest request, HttpSession session) {
        //验证码判断
        if (!CaptchaUtil.ver(captcha, request)) {
            return Result.fail("验证码错误！");
        }

        //将输入的密码 和 真实的密码进行比较
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = userService.login(param);
        //记得match函数的参数顺序
        if (user != null && passwordEncoder.matches(param.getPassword(), user.getPassword())) {
            session.setAttribute("userInfo", user);
            return Result.success("登录成功");
        }
        return Result.fail("用户名或密码错误");
    }

}
