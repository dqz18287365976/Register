package tedu.cs_mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tedu.entity.Users;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users where username=#{username}")
    Users selectByName(String username);

    @Select("insert into users values(null,#{username},#{password})")
    void addUser(Users users);




}
