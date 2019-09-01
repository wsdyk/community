package top.wsdyk.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import top.wsdyk.community.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name.account_id,token,gmt_create,gmt_modified) " +
            "values (#{name},#{accountid},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
