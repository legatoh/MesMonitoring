package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteDAOImpl;
import model.ProductVO;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		DeleteDAOImpl deleteDAOImpl = new DeleteDAOImpl();		// 새로운 DeleteDAOImpl 객체 생성

		String code = request.getParameter("code");
		
		ProductVO item = new ProductVO(code);	// 입력받은 코드를 통해 새 productVO 객체 생성
		
		deleteDAOImpl.deleteRow(item);				// code와 일치하는 쿼리문에서 정보를 추출하여 객체 삭제
				
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
