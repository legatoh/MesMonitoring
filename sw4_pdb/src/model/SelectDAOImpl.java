package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectDAOImpl extends DAOBase implements DAO {
	private static final String Q_SELECT_ITEM = "SELECT * FROM PRODUCT WHERE code = ?;";
	private static final String Q_SELECT_PRE_ITEM = "SELECT * FROM PRODUCT WHERE JNUM < PNUM * 20 / 100;";
	private static final String Q_SELECT_RANK_ITEM = "SELECT PNAME AS '제품이름', COST*JNUM AS '총이익' FROM PRODUCT ORDER BY COST*JNUM DESC;";
	private static final String Q_SELECT_STOCK_ITEM = "SELECT GCODE AS '그룹이름', SUM(JNUM) AS '재고수량' FROM PRODUCT GROUP BY GCODE;";
	
	public ProductVO selectRow(ProductVO item) { 
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
	
	public ArrayList<ProductVO> selectRowPre() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<ProductVO> items = new ArrayList<>();

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
				
				items.add(new ProductVO(code, pname, cost,
						pnum, jnum, sale, gcode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return items;
	}
	
	public ArrayList<RankVO> selectRowRank() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<RankVO> items = new ArrayList<>();
		
		try {
			pstm = conn.prepareStatement(Q_SELECT_RANK_ITEM);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				String pname = rs.getString("제품이름");
				String scost = rs.getString("총이익");
				
				items.add(new RankVO(pname, scost));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return items;
	}
	
	public ArrayList<StockVO> selectRowStock() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<StockVO> items = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(Q_SELECT_STOCK_ITEM);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				String gname = rs.getString("그룹이름");
				String jnum = rs.getString("재고수량");
				
				items.add(new StockVO(gname, jnum));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDBResources();
		return items;
	}

}
