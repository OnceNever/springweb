package com.yanglei.mybatis.mapper;

import com.yanglei.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
