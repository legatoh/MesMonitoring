package model;

public class ProductVO {
	public String code;
	public String pname;
	public String cost;
	public String pnum;
	public String jnum;
	public String sale;
	public String gcode;
	
	public ProductVO(String code) {
		super();
		this.code = code;
		this.pname = "";
		this.cost = "";
		this.pnum = "";
		this.jnum = "";
		this.sale = "";
		this.gcode = "";
	}

	public ProductVO(String code, String pname, String cost, String pnum, String jnum, String sale, String gcode) {
		super();
		this.code = code;
		this.pname = pname;
		this.cost = cost;
		this.pnum = pnum;
		this.jnum = jnum;
		this.sale = sale;
		this.gcode = gcode;
	}
	
}
