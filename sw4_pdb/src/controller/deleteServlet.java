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
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: delete").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		
		DAOBase daoBase = new DAOBase();		// 새로운 DAOBase 객체 생성

		String code = request.getParameter("code");
		
		productVO item = new productVO(code);	// 입력받은 코드를 통해 새 productVO 객체 생성
		
		daoBase.deleteRow(item);				// code와 일치하는 쿼리문에서 정보를 추출하여 객체 삭제
				
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/productSelectUpdate.jsp"); //넘길 페이지 주소
        dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
