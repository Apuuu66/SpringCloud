package com.guier.eurekaclientmovie.feign;

import com.guier.eurekaclientmovie.pojo.User;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@FeignClient(name = "eureka-client-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

/*除此之外，还可使用url属性指定请求的URL（URL可以是完整的URL或主机名），
例如@FeignClient(name = "abcde", url = "http://localhost:8000/") 。
此时，name可以是任意值，但不可省略，否则应用将无法启动！*/
class FeignConfiguration {
    //设置feign拦截器，将请求头转发
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String values = request.getHeader(name);
                        System.out.println(name + ":" + values);
                        requestTemplate.header(name, values);
                    }
                }
            }
        };
    }
}
