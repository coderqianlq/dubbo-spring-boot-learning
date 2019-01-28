package com.coderqian.dubboconsumer.converter;

import com.coderqian.dubboconsumer.model.vo.UserVo;
import com.coderqian.dubbocore.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qianliqing
 * @date 2019/1/28 5:27 PM
 * email: qianlq0824@gmail.com
 */

@Mapper(componentModel = "spring")
public interface User2UserVoMapper {

    User2UserVoMapper INSTANCE = Mappers.getMapper(User2UserVoMapper.class);

    /**
     * userDto to userVo
     *
     * @param user 用户
     * @return UserVo
     */
    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "birth", source = "user.birth")
    })
    UserVo user2UserVo(UserDto user);

    /**
     * userDto to userVo
     *
     * @param users 用户
     * @return List<UserVo>
     */
    List<UserVo> users2UserVos(List<UserDto> users);
}
