package top.wsdyk.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.wsdyk.community.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into USER (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountid},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from USER where token = #{token}")
    User findByToken(@Param("token") String token);
}
