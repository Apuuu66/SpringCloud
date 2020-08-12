package com.guier.configclient.bo;

import com.guier.configclient.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

// http://www.iocoder.cn/Spring-Boot/MapStruct/
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserBO convert(User user);

    @Mappings(value = {@Mapping(source = "id", target = "userId"), @Mapping(source = "user.age", target = "name")})
    UserDetailBO convertDetail(User user);
}
