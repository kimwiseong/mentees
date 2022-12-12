package mentees.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	private static final MemberService memberService = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		
		String message = memberService.save(new Member(name, email, password, passwordCheck));
		
		if (message.equals("회원가입에 성공하였습니다.")) 
			out.print("<script>alert('" + message + "'); location.href='login.jsp' </script>");
		else 
			out.print("<script>alert('" + message + "'); history.back(); </script>");
		
		out.close();
		
	}
}
