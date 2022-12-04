package mentees.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mentees.service.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final LoginService loginService = new LoginService();
       
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false);
		
		
		if (session != null) {
			session.invalidate();
			request.getSession(true);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그아웃 하였습니다.'); location.href='login.jsp'; </script>");
			out.close();
		} 
		else {
			response.sendRedirect("login.jsp"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if(loginService.findMember(email, password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			response.sendRedirect("main");
		}
		else {
			out.print("<script>alert('아이디 또는 비밀번호를 다시 입력해주세요'); history.back(); </script>");
		}
		
	}

}


//mainpage
//
