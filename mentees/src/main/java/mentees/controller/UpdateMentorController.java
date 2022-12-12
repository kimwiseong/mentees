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

import mentees.service.MemberService;
import mentees.service.MentorService;

/**
 * Servlet implementation class UpdateMentorController
 */
@WebServlet("/updateRecruit")
public class UpdateMentorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
	private static final MentorService mentorService = new MentorService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMentorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email"); 
		if (email == null) {
			out.print("<script>alert('로그인 후 이용해주세요'); location.href='login.jsp'; </script>");
		}
		else {
			request.setAttribute("mentorList", mentorService.readMentorList());
			RequestDispatcher dispatch =  request.getRequestDispatcher("mentoRecruitmentPage.jsp");
			dispatch.forward(request, response);
		}
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
			
			String memberName = memberService.findMemberNameByEmail(email);
			String studyName = mentorService.findNameById(id);
			String subject = request.getParameter("subject");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			boolean isDelete = false;
			
			if (memberName.equals(studyName)) 
				isDelete = mentorService.update(id, title, subject, content);
				
			if (isDelete) {
				out.print("<script>alert('수정했습니다.'); location.href='mentrecruit'; </script>");
			}
			else {
				out.print("<script>alert('수정 권한이 필요합니다.'); history.back(); </script>");
			}
		}
	}

}
