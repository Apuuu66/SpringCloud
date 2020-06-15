1. 引入依赖，在SpringBoot的spring-boot-starter-web中默认引入了
```text
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.1.5.Final</version>
</dependency>
```
2. 注解说明
```text
1.@NotNull：不能为null，但可以为empty(""," ","   ")      
2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test")   即：必须有实际字符
```
3. restful风格用法

在多个参数校验,或者@RequestParam 形式时候,需要在controller上加注@Validated
```text
 @GetMapping("/get")
    public RspDTO getUser(@RequestParam("userId") @NotNull(message = "用户id不能为空") Long userId) {
        User user = userService.selectById(userId);
        if (user == null) {
            return new RspDTO<User>().nonAbsent("用户不存在");
        }
        return new RspDTO<User>().success(user);
    }

@RestController
@RequestMapping("user/")
@Validated
public class UserController extends AbstractController {

...
}

```
[参考](https://juejin.im/post/5d3fbeb46fb9a06b317b3c48)