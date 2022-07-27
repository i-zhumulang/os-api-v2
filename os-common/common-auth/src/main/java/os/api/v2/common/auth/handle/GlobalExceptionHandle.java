package os.api.v2.common.auth.handle;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import os.api.v2.common.base.common.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandle {
    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param exception Exception
     * @return com.common.os.entity.Result
     * @author 吴荣超
     * @date 0:56 2022/5/8
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> error(HttpServletRequest request,
                                HttpServletResponse response,
                                Exception exception
    ) {
        exception.printStackTrace();
        return new Result<>(Result.FAILURE, "抱歉，系统繁忙，请稍后重试！");
    }

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param exception AuthorizationException
     * @return com.common.os.entity.Result
     * @author 吴荣超
     * @date 0:56 2022/5/8
     */
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result<Object> authorizationException(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 AuthorizationException exception
    ) {
        return new Result<>(Result.FAILURE, "权限不足");
    }

    /**
     * 参数验证错误
     *
     * @param exception MethodArgumentNotValidException
     * @return com.common.os.entity.Result
     * @author 吴荣超
     * @date 0:56 2022/5/8
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String message = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return new Result<>(Result.FAILURE, message);
    }
}
