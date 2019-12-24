package com.ljb.test.mapper;

import com.ljb.test.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int saveUser(User user);

    List<User> queryAllUser();

    User queryUserByNmae(String name);

    int editUserInfo(User user);

    List<User> queryUserById(List<Integer> ids);
}
