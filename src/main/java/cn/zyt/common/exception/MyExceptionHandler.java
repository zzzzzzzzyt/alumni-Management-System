package cn.zyt.common.exception;

import cn.zyt.common.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> myHandler(Exception e) {
        return Result.fail("系统错误" + e.getMessage());
    }
}
