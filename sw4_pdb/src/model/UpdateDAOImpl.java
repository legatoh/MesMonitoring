package model;

import java.sql.SQLException;

public class UpdateDAOImpl extends DAOBase implements DAO {
	
	private static final String Q_UPDATE_ITEM = "UPDATE PRODUCT SET "
			+ "pname = ?, cost = ?, pnum = ?, jnum = ?,"
			+ "sale = ?, gcode = ? WHERE code = ? ;";
	
	public ProductVO updateRow(ProductVO item) {
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
}
