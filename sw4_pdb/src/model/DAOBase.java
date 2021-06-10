package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase implements DAO {
	private Connection conn = null; // DB 연결 상태
	private PreparedStatement pstm = null; // SQL문
	private ResultSet rs = null; // SQL문 결과

	public Connection getConnection() throws SQLException {
		String jdbc_driver = "org.mariadb.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/mysql";
		// String jdbc_driver = "com.mysql.jdbc.Driver";
		// String db_url = "jdbc:mysql://127.0.0.1:3306/mysql";

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

	private static final String Q_INSERT_ITEM = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
	private static final String Q_SELECT_ITEM = "SELECT * FROM PRODUCT WHERE code = '?'";

	public void insertRow(productVO item) {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pstm = conn.prepareStatement(Q_INSERT_ITEM);
			pstm.setString(1, item.code);
			pstm.setString(2, item.pname);
			pstm.setString(3, item.cost);
			pstm.setString(4, item.pnum);
			pstm.setString(5, item.jnum);
			pstm.setString(6, item.sale);
			pstm.setString(7, item.gcode);

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
	}

	public productVO selectRow(productVO item) {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pstm = conn.prepareStatement(Q_SELECT_ITEM);
			pstm.setString(1, item.code);
			rs = pstm.executeQuery();
			
			item.pname = rs.getString("pname");
			item.cost = rs.getString("cost");
			item.pnum = rs.getString("pnum");
			item.jnum = rs.getString("jnum");
			item.sale = rs.getString("sale");
			item.gcode = rs.getString("gcode");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return item;

	}

}
