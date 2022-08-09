import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("연결완료");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC연결오류");
		} catch (SQLException e) {
			System.out.println("db연결 오류");
		}
	}

}
