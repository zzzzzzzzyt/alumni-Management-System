package cn.zyt.mapper;

import cn.zyt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper
{
    User getUser(User user);
}
