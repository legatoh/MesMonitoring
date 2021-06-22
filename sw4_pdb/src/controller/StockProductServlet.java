package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SelectDAOImpl;
import model.StockVO;

/**
 * Servlet implementation class StockProductServlet
 */
@WebServlet("/StockProductServlet")
public class StockProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockProductServlet() {
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
		// 쿼리값 받을 productVO 리스트 생성
		ArrayList<StockVO> items = new ArrayList<>();	
		
		// code와 일치하는 쿼리문에서 정보를 추출하여 객체 업데이트
		items = selectDAOImpl.selectRowStock();				
		// 정보값 담은 객체 전달
		request.setAttribute("StockList", items);
		
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/StockSelected.jsp"); //넘길 페이지 주소
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
