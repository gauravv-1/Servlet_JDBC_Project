package bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.DTHRecharge;
import bank.model.Recharge;

/**
 * Servlet implementation class DTHController
 */
@WebServlet("/DTHController")
public class DTHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DTHController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String consumerNo = request.getParameter("consumerNo");
		String operator = request.getParameter("operator");
		int amt = Integer.parseInt(request.getParameter("amt"));
		HttpSession session = request.getSession();
	
		DTHRecharge rechDTH = new DTHRecharge(consumerNo, operator, amt);
		session.setAttribute("rechDetailsDTH", rechDTH);
		response.sendRedirect("ConfirmRechargeDetailsDTH.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
