

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import chauncy.entity.Users;




public class TestMybatis {
	public static void main(String[] args) throws IOException {
		show();
	}
	
	static	public void show() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		//通过命名空间+id
		String statement="chauncy.mapper.UsersMapper.getUsers";
		Users users = openSession.selectOne(statement,1);
		System.out.println(users.toString());
		openSession.close();
	}
}
