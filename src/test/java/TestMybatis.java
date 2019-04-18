

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import chauncy.entity.Users;
import chauncy.entity.UsersTable;
import chauncy.mapper.UsersMapper;




public class TestMybatis {
	public static void main(String[] args) throws IOException {
		//upd();
		//login();
		showByAnnocation();
	}
	
	static	public void showByXml() throws IOException{
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
	
	static	public void add() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		//通过命名空间+id
		String statement="chauncy.mapper.UsersMapper.addUsers";
		Users addUsers = new Users();
		addUsers.setName("ChauncyWang");
		addUsers.setAge(18);
		//返回影响行数
		int insert = openSession.insert(statement,addUsers);
		openSession.commit();
		System.out.println("insert:"+insert);
		openSession.close();
	}
	
	static	public void upd() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		//通过命名空间+id
		String statement="chauncy.mapper.UsersMapper.updUsers";
		Users updUsers = new Users();
		updUsers.setId(3);
		updUsers.setName("chauncy");
		updUsers.setAge(20);
		//返回影响行数
		int update = openSession.update(statement,updUsers);
		openSession.commit();
		System.out.println("update:"+update);
		openSession.close();
	}
	
	static	public void del() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		//通过命名空间+id
		String statement="chauncy.mapper.UsersMapper.delUsers";
		int delete = openSession.delete(statement,3);
		openSession.commit();
		System.out.println("delete:"+delete);
		openSession.close();
	}
	
	static public void login() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		//通过命名空间+id
		String statement="chauncy.mapper.UsersTableMapper.login";
		UsersTable usersTable = new UsersTable();
		usersTable.setUserName("'' or 1=1 --");
		usersTable.setPassWord("'123456'");
		List<UsersTable> usersTableList = openSession.selectList(statement,usersTable);
		for (UsersTable usersTable2 : usersTableList) {
			System.out.println(usersTable2.toString());
		}
		openSession.close();
	}
	
	static	public void showByAnnocation() throws IOException{
		String resource="mybatis.xml";
		//读取配置文件
		Reader resourceAsReader = Resources.getResourceAsReader(resource);
		//创建session会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//获取sql会话
		SqlSession openSession = sqlSessionFactory.openSession();
		UsersMapper usersMapper = openSession.getMapper(UsersMapper.class);
		Users users = usersMapper.getUsers(1);
		System.out.println(users.toString());
		openSession.close();
	}
}
