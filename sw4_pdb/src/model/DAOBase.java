package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase implements DAO {
	public Connection conn; // DB 연결 상태
	public PreparedStatement pstm; // SQL문
	public ResultSet rs; // SQL문 결과
	
	public DAOBase() {
		super();
		this.conn = null;
		this.pstm = null;
		this.rs = null;
	}

	public Connection getConnection() throws SQLException {
		String jdbc_driver = "org.mariadb.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/mysql";

		try {
			Class.forName(jdbc_driver);
			Connection conn = DriverManager.getConnection(db_url, "system", "hrdkorea");
			System.out.println("접속 성공");
			return conn;
		} catch (Exception e) {
			System.out.println("접속 실패");
			System.out.println(e);
			// e.printStackTrace();
		}
		return null;
	}

	public void closeDBResources() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
