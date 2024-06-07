package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.dao.BillDao;
import bank.dao.BillDaoImpl;
import bank.model.DTHRecharge;
import bank.model.DTHRechargeBill;
import bank.model.Recharge;
import bank.model.RechargeBill;
import bank.model.Register;

/**
 * Servlet implementation class RechargeBillControllerDTH
 */
@WebServlet("/RechargeBillControllerDTH")
public class RechargeBillControllerDTH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeBillControllerDTH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean sufficientBal=false;
		int i=0;
		java.util.Date billDate = new java.util.Date();
		HttpSession session  = request.getSession();
		PrintWriter pw = response.getWriter();
		DTHRecharge rechDTH = (DTHRecharge)session.getAttribute("rechDetailsDTH");
		Register reg = (Register)session.getAttribute("loginInfo");
		BankDao bdao = new BankDaoImpl();
		BillDao billdao = new BillDaoImpl();
		sufficientBal=bdao.validateBalance(rechDTH.getAmt(),reg.getAccNo());
		
		if(sufficientBal) {
			i=bdao.updateBalance((reg.getAccBal()-rechDTH.getAmt()), reg.getAccNo());
			if(i>0) {      
				//pw.println("Recharge Sucessfull!!!");
				RechargeBill rechBill = new RechargeBill(1, billDate, rechDTH.getAmt(), reg.getAccNo(), rechDTH.getConsumerNo(), rechDTH.getOperator());
				int j = billdao.createRechargeTransaction(rechBill);
				
				
				if(j>0) {
					
					session.setAttribute("RechTxn", rechBill);
					
					response.sendRedirect("RechargeTxnViewDTH.jsp");
				}
				
				else {
					pw.println("Recharge Failed!!!");
				}
			}	

		}
		
		else {
			pw.println("Insufficient Funds!!");
		}
		
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
