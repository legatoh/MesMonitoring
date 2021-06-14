package model;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOBase implements DAO {
	private Connection conn = null; // DB 연결 상태
	private PreparedStatement pstm = null; // SQL문
	private ResultSet rs = null; // SQL문 결과

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

	
	//=========================================================================
	
	private static final String Q_INSERT_ITEM = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
	private static final String Q_SELECT_ITEM = "SELECT * FROM PRODUCT WHERE code = ?;";
	private static final String Q_UPDATE_ITEM = "UPDATE PRODUCT SET "
										+ "pname = ?, cost = ?, pnum = ?, jnum = ?,"
										+ "sale = ?, gcode = ? WHERE code = ?;";
	private static final String Q_DELETE_ITEM = "DELETE FROM PRODUCT WHERE code = ?";
	private static final String Q_SELECT_PRE_ITEM = "SELECT * FROM PRODUCT WHERE JNUM < PNUM * 20 / 100;";

	public void insertRow(productVO item) {
		try {
			conn = getConnection();
		} catch (SQLException e) {
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
			e.printStackTrace();
		}

		try {
			pstm = conn.prepareStatement(Q_SELECT_ITEM);
			pstm.setString(1, item.code);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				item.pname = rs.getString("pname");
				item.cost = rs.getString("cost");
				item.pnum = rs.getString("pnum");
				item.jnum = rs.getString("jnum");
				item.sale = rs.getString("sale");
				item.gcode = rs.getString("gcode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return item;

	}

	public productVO updateRow(productVO item) {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			pstm = conn.prepareStatement(Q_UPDATE_ITEM);
			pstm.setString(1, item.pname);
			pstm.setString(2, item.cost);
			pstm.setString(3, item.pnum);
			pstm.setString(4, item.jnum);
			pstm.setString(5, item.sale);
			pstm.setString(6, item.gcode);
			pstm.setString(7, item.code);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return item;

	}
	
	public void deleteRow(productVO item) {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			pstm = conn.prepareStatement(Q_DELETE_ITEM);
			pstm.setString(1, item.code);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		
	}
	
	public ArrayList<productVO> selectRowPre() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<productVO> items = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(Q_SELECT_PRE_ITEM);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("code");
				String pname = rs.getString("pname");
				String cost = rs.getString("cost");
				String pnum = rs.getString("pnum");
				String jnum = rs.getString("jnum");
				String sale = rs.getString("sale");
				String gcode = rs.getString("gcode");
				
				items.add(new productVO(code, pname, cost,
						pnum, jnum, sale, gcode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return items;

	}
}
