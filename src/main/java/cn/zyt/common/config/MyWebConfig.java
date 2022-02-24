package cn.zyt.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类 进行配置 比如说拦截器的配置等等
@Configuration
public class MyWebConfig implements WebMvcConfigurer
{
    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //在添加拦截器后 会返回一个拦截器的注册对象
        InterceptorRegistration interceptorRegistration =
                registry.addInterceptor(handlerInterceptor);
        //拦截请求
        interceptorRegistration.addPathPatterns("/**");//需要的是 拦截所有 后面就是一些 拦截部分

        //放行请求
        interceptorRegistration.excludePathPatterns(
                "/login",
                "/captcha",
                "/user/login",
                "/user/logout",
                "/css/**",
                "/font/**",
                "/lib/**",
                "/webjars/**",
                //因为我的layui 不在文件夹里  视频中是包括了 所以我要额外往里面加
                "/layui.js",
                "/api/**",
                "/js/**",
                "/images/**"
                //路径加/是根目录下的绝对路径  不加/是当前目录下的相对路径
        );
    }
}
