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
import bank.model.Register;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Register> rList=null;
	
       
	public void init() {
    	rList = new ArrayList<Register>();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// TODO Auto-generated method stub
		String fName=request.getParameter("fName");
		String lName=request.getParameter("lName");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		int accNo = Integer.parseInt(request.getParameter("accNo"));
		float accBal = Float.parseFloat(request.getParameter("accBal"));
		
		Register r = new Register(fName, lName, uname, password, accNo, accBal);
		rList.add(r);
		BankDao bdao = new BankDaoImpl();
		int i=bdao.registerUser(rList);	
		
		if(i>0) {
			//pw.println("Registration Sucessfull!!");
			request.setAttribute("sucessMessage", "Registration Sucessfull!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("Home.jsp");
		}
		
		else {
			pw.println("Registration Failed!!");
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("rList", rList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
