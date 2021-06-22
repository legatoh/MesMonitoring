package model;

import java.sql.SQLException;

public class DeleteDAOImpl extends DAOBase implements DAO {
	private static final String Q_DELETE_ITEM = "DELETE FROM PRODUCT WHERE code = ?";

	public void deleteRow(ProductVO item) {
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
}
