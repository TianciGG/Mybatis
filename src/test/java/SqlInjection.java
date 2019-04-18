import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**   
 * @classDesc: 功能描述(SQL注入攻击)  
 * @author: ChauncyWang
 * @createTime: 2019年4月17日 下午4:24:22   
 * @version: 1.0  
 */  
public class SqlInjection {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//注入式攻击方法
		//String username = "' or 1=1 -- ";
		String username="' or 1=1 -- ";
		String password = "123456";
		/*//拼接SQL的方式，容易产生SQL注入式攻击
		String sql = "SELECT id,username FROM user_table WHERE " + "username='" + username + "'AND " + "password='"
						+ password + "'";*/
		//使用？号方式，进行预编译SQL，防止注入式攻击
		String sql = "SELECT id,username FROM user_table WHERE username= ? AND password= ?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/architect?serverTimezone=GMT", "root", "root");
		PreparedStatement stat = con.prepareStatement(sql);
		stat.setString(1, username);
		stat.setString(2, password);
		System.out.println(stat.toString());
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			System.out.println("id:" + id + "---name:" + name);
		}
	}
}
