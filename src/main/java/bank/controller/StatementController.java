package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.BillDao;
import bank.dao.BillDaoImpl;
import bank.model.RechargeBill;
import bank.model.Register;

/**
 * Servlet implementation class StatementController
 */
@WebServlet("/StatementController")
public class StatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BillDao bdao = new BillDaoImpl();
		List<RechargeBill> txnList = new ArrayList<RechargeBill>();
		HttpSession session  = request.getSession();
		Register reg = (Register)session.getAttribute("loginInfo");
		txnList=bdao.retriveRechargeTransactions(reg.getAccNo());
		
			session.setAttribute("TxnsDetails", txnList);
			response.sendRedirect("StatementView.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
