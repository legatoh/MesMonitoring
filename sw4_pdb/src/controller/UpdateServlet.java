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
import model.UpdateDAOImpl;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
		// 새로운 SelectDAOImpl 객체 생성
		UpdateDAOImpl updateDAOImpl = new UpdateDAOImpl();

		// 전체 정보 가져오기
		String code = request.getParameter("code");
		String pname = request.getParameter("pname");
		String cost = request.getParameter("cost");
		String pnum = request.getParameter("pnum");
		String jnum = request.getParameter("jnum");
		String sale = request.getParameter("sale");
		String gcode = request.getParameter("gcode");
		
		// 입력받은 정보를 통해 새 productVO 객체 생성
		ProductVO item = new ProductVO(code, pname, cost, pnum,
										jnum, sale, gcode);
		
		// code와 일치하는 쿼리문에서 정보를 추출하여 객체 업데이트
		if(code != null && pname != null) {
			updateDAOImpl.updateRow(item);
		}
		
		// 업데이트한 정보를 원래 화면으로 전송
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
		doGet(request, response);
	}

}
