package com.yanglei.springshiro.mapper;

import com.yanglei.springshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User queryByName(String name);

}
