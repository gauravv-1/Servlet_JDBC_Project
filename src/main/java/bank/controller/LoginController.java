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
import bank.model.RechargeBill;
import bank.model.Register;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    List<RechargeBill> rechTxns = null;  
   /**
    * @see HttpServlet#HttpServlet()
    */
    
    public void init() {
   	 rechTxns = new ArrayList<RechargeBill>();
    } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Register> rList=null;
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		BankDao bdao = new BankDaoImpl();
		rList=bdao.validateUser(uname, password);

		if(!rList.isEmpty()) {
			Register r =  rList.get(0);
			pw.println("Login Sucessfull!!");
			session.setAttribute("loginInfo", r);
			session.setAttribute("rechTxns", rechTxns);
			response.sendRedirect("DashboardView.jsp");
			
		}
		
		else {
			request.setAttribute("errorMessage", "Invalid username or Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//pw.println("Invalid Login Id or Password");
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
