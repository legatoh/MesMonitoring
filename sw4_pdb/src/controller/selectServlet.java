package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOBase;
import model.productVO;

/**
 * Servlet implementation class selectServlet
 */
@WebServlet("/selectServlet")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectServlet() {
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
		Enumeration<String> param = request.getParameterNames();
		
		DAOBase daoBase = new DAOBase();		// 새로운 DAOBase 객체 생성

		String code = request.getParameter("code");
		
		productVO item = new productVO(code);	// 입력받은 코드를 통해 새 productVO 객체 생성
		
		daoBase.selectRow(item);				// code와 일치하는 쿼리문에서 정보를 추출하여 객체 업데이트
		
		// item에서 받은 정보를 원래 화면으로 전송
		request.setAttribute("code", item.code);
		request.setAttribute("pname", item.pname);
		request.setAttribute("cost", item.cost);
		request.setAttribute("pnum", item.pnum);
		request.setAttribute("jnum", item.jnum);
		request.setAttribute("sale", item.sale);
		request.setAttribute("gcode", item.gcode);
		
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/productSelectUpdate.jsp"); //넘길 페이지 주소
        dispatcher.forward(request, response);
		}
	
		// http://www.devkuma.com/books/pages/858 참고하여 리다이렉트로 고칠것

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
