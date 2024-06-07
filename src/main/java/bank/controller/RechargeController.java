package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Recharge;
import bank.model.Register;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Recharge> rechList = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		rechList = new ArrayList<Recharge>();
	}
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String mobNo = request.getParameter("mobNo");
		String serviceProvider = request.getParameter("serviceProvider");
		int rechAmt = Integer.parseInt(request.getParameter("rechAmt"));
		HttpSession session = request.getSession();
	
		Recharge rech = new Recharge(mobNo, serviceProvider, rechAmt);
		session.setAttribute("rechDetails", rech);
		response.sendRedirect("ConfirmRechargeDetails.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
