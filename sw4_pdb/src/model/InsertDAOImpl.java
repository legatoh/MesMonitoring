package model;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertDAOImpl extends DAOBase implements DAO {
	private static final String Q_INSERT_ITEM = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
	
	public void insertRow(ProductVO item) {
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
}
