package chauncy.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import chauncy.entity.Users;

public interface UsersMapper {
	
	@Select("select * from users where id=#{id}")
	public Users getUsers(@Param("id")int id);
	
	public void addUsers(Users users);
	
	public void delUsers(int id);
	
	public void updUsers(Users users);
}
