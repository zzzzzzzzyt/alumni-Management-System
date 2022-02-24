package cn.zyt.common.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//防止 用户未登录时  直接对一个网页进行访问
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //根据session中是否存在用户信息进行 拦截
        if (request.getSession().getAttribute("userInfo")==null)
        {
            log.debug("未登录请求:"+request.getRequestURI());
            //未登录  则进行重定向
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        log.debug("放行请求:"+request.getRequestURI());
        return true;
    }
}
