package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import model.SelectDAOImpl;

/**
 * Servlet implementation class selectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 새로운 SelectDAOImpl 객체 생성
		SelectDAOImpl selectDAOImpl = new SelectDAOImpl();
		// select문에 사용할 code 저장
		String code = request.getParameter("code");
		// 입력받은 코드를 통해 새 productVO 객체 생성
		ProductVO item = new ProductVO(code);	
		// code와 일치하는 쿼리문에서 정보를 추출하여 객체 업데이트
		selectDAOImpl.selectRow(item);
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
