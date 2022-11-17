package mentees.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mentees.entity.Member;
import mentees.service.MemberService;


@WebServlet("/join")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	private MemberService memberService = new MemberService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		System.out.println(name+ " " + email + " " + password + " " + passwordCheck);
		
		String message = memberService.save(new Member(name, email, password, passwordCheck));
		System.out.println(message);
		response.sendRedirect(message);
	}
}
