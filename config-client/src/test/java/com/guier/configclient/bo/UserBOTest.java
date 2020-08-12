package com.guier.configclient.bo;

import com.guier.configclient.pojo.User;
import org.junit.Test;

public class UserBOTest {

    @Test
    public void ttt() throws Exception {
        // 创建 UserDO 对象
        User userDO = new User().setId(1).setName("zhangsan").setAge(18);
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO);
        UserDetailBO userDetailBO = UserConvert.INSTANCE.convertDetail(userDO);
        System.out.println(userDetailBO);
    }
}