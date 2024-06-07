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
	import bank.dao.BillDao;
	import bank.dao.BillDaoImpl;
	import bank.model.Recharge;
	import bank.model.RechargeBill;
	import bank.model.Register;
	
	/**
	 * Servlet implementation class RechargeBillController
	 */
	@WebServlet("/RechargeBillController")
	public class RechargeBillController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	     List<RechargeBill> rechTxns = null;  
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	     
	     public void init() {
	    	 rechTxns = new ArrayList<RechargeBill>();
	     }
	    public RechargeBillController() {
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
			Recharge rech = (Recharge)session.getAttribute("rechDetails");
			Register reg = (Register)session.getAttribute("loginInfo");
			BankDao bdao = new BankDaoImpl();
			sufficientBal=bdao.validateBalance(rech.getRechAmt(),reg.getAccNo());
			
			if(sufficientBal) {
				i=bdao.updateBalance((reg.getAccBal()-rech.getRechAmt()), reg.getAccNo());
				if(i>0) {
					pw.println("Recharge Sucessfull!!!");
					RechargeBill rechBill = new RechargeBill(1, billDate, rech.getRechAmt(), reg.getAccNo(), rech.getMobNo(), rech.getServiceProvider());
					BillDao billdao = new BillDaoImpl();
					int j = billdao.createRechargeTransaction(rechBill);
					
					System.out.println(rechTxns);
					if(j>0) {
						rechTxns.add(rechBill);
						session.setAttribute("RechTxn", rechBill);
						
						response.sendRedirect("RechargeTxnView.jsp");
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
