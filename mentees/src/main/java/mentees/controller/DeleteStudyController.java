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
import mentees.service.StudyService;

/**
 * Servlet implementation class DeleteStudyController
 */
@WebServlet("/deleteStudy")
public class DeleteStudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
	private static final StudyService studyService = new StudyService();
       
    public DeleteStudyController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	}

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
			int id = Integer.parseInt(request.getParameter("id"));
			String memberName = memberService.findMemberNameByEmail(email);
			String studyName = studyService.findNameById(id);
			boolean isDelete = false;
			
			if (memberName.equals(studyName)) 
				isDelete = studyService.deleteById(id);
			if (isDelete) {
				out.print("<script>alert('삭제했습니다.'); location.href='study' </script>");
			}
			else {
				out.print("<script>alert('삭제 권한이 필요합니다.'); history.back(); </script>");
			}
		}
	}
}
