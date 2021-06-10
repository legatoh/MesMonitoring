package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOBase;
import model.productVO;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(request.getParameter("code") != null){
			pw.println("<html>");
			pw.println("<body>");
			pw.println("입력된 정보가 없습니다.</br>");
			pw.println("<a href='productManagerSystem.jsp'>메인화면으로</a>");
			pw.println("</body>");
			pw.println("</html>");
		} 
		else {
		
		DAOBase daoBase = new DAOBase();

		String code = request.getParameter("code");
		String pname = request.getParameter("pname");
		String cost = request.getParameter("cost");
		String pnum = request.getParameter("pnum");
		String jnum = request.getParameter("jnum");
		String sale = request.getParameter("sale");
		String gcode = request.getParameter("gcode");
		
		productVO item = new productVO(code, pname, cost, pnum, jnum, sale, gcode);

		daoBase.insertRow(item);
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("둥록완료</br>");
		pw.println("<a href='productManagerSystem.jsp'>메인화면으로</a>");
		pw.println("</body>");
		pw.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
