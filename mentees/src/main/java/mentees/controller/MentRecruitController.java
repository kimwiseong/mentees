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
import mentees.entity.Page;
import mentees.service.MemberService;
import mentees.service.MentorService;

/**
 * Servlet implementation class MentRecruitController
 */
@WebServlet("/mentrecruit")
public class MentRecruitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
	private static final MentorService mentorService = new MentorService();
	private static Page page;
	

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
			int pageNum = 1;
			if(request.getParameter("pageNum") != null) 
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			
			int total = mentorService.total();
			page = new Page(pageNum, total); 
			
			request.setAttribute("page", page);
			request.setAttribute("mentorList", mentorService.readMentorPaging(page.getAmount(), pageNum));
			RequestDispatcher dispatch =  request.getRequestDispatcher("mentoRecruitmentPage.jsp");
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email"); 
		
		String name = memberService.findMemberNameByEmail(email);
		String subject = request.getParameter("subject");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isInsert = mentorService.insertMentor(new Mentor(subject, title, content, name));
		
		if (isInsert) {
			out.print("<script>alert('글을 등록했습니다'); location.href='mentrecruit'; </script>");
		}
		else 
			out.print("<script>alert('글 작성에 실패했습니다'); history.back(); </script>");
		
	}

}
