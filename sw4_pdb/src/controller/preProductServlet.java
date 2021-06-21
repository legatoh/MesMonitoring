package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class preProductServlet
 */
@WebServlet("/preProductServlet")
public class preProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public preProductServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		DAOBase daoBase = new DAOBase();		// 새로운 DAOBase 객체 생성
		ArrayList<productVO> items = new ArrayList<>();	// 쿼리값 받을 productVO 리스트 생성
		
		items = daoBase.selectRowPre();				// code와 일치하는 쿼리문에서 정보를 추출하여 객체 업데이트
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("list", items);		// list라는 이름으로 정보값 담은 객체 전달
		
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/preProductSelect.jsp"); //넘길 페이지 주소
        dispatcher.forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
