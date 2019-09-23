package com.guier.eurekaclientmovie.feign;

import com.guier.eurekaclientmovie.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eureka-client-user",fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
/*除此之外，还可使用url属性指定请求的URL（URL可以是完整的URL或主机名），
例如@FeignClient(name = "abcde", url = "http://localhost:8000/") 。
此时，name可以是任意值，但不可省略，否则应用将无法启动！*/
