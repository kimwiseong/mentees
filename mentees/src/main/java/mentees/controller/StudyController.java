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

import mentees.entity.Study;
import mentees.service.MemberService;
import mentees.service.StudyService;

/**
 * Servlet implementation class StudyController
 */
@WebServlet("/study")
public class StudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
	private static final StudyService studyService = new StudyService();
       
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
			request.setAttribute("studyList", studyService.readStudyList());
			RequestDispatcher dispatch =  request.getRequestDispatcher("menteeRecruitmentPage.jsp");
			dispatch.forward(request, response);
		}
//		response.sendRedirect("menteeRecruitmentPage.jsp"); 
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
		String name = memberService.findMemberNameByEmail(email);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		boolean isInsert = studyService.insert(new Study(title, content, name));
		if (isInsert) {
			out.print("<script>alert('글을 등록했습니다');</script>");
			doGet(request, response);
		}
		else 
			out.print("<script>alert('글 작성에 실패했습니다'); history.back(); </script>");
	}

}
