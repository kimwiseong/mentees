package mentees.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mentees.entity.Mentor;
import mentees.service.MemberService;

/**
 * Servlet implementation class CheckMentorController
 */
@WebServlet("/checkMentor")
public class CheckMentorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMentorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email"); 
		if (email == null) {
			out.print("<script>alert('로그인 후 이용해주세요'); location.href='login.jsp'; </script>");
		}
		else {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String subject = request.getParameter("subject").trim();
			String name = request.getParameter("name").trim();
			String title = request.getParameter("title").trim();
			String content = request.getParameter("content").trim();
			String memberName = memberService.findMemberNameByEmail(email);
			System.out.println(name + " " + memberName);
			
			if (memberName.equals(name)) {
				request.setAttribute("mentor", new Mentor(id, subject, title, content, name));
				RequestDispatcher dispatch =  request.getRequestDispatcher("modifyMentor.jsp");
				dispatch.forward(request, response);
			}
			else 
				out.print("<script>alert('권한이 필요합니다.'); history.back(); </script>");

		}
	}

}
