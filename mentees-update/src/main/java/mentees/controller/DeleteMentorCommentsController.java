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
import mentees.service.MentorCommentsService;
import mentees.service.MentorService;

/**
 * Servlet implementation class DeleteMentorCommentsController
 */
@WebServlet("/deleteMentorComments")
public class DeleteMentorCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
	private static final MentorService mentorService = new MentorService();
	private static final MentorCommentsService mentorCommentsService = new MentorCommentsService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMentorCommentsController() {
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
			int id = Integer.parseInt(request.getParameter("mentorId"));
			request.setAttribute("mentor", mentorService.findById(id));
			request.setAttribute("comments", mentorCommentsService.read(id));
			RequestDispatcher dispatch =  request.getRequestDispatcher("showMentoList.jsp");
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
			int mentorId = Integer.parseInt(request.getParameter("mentorId").trim());
			
			String commentName = request.getParameter("commentName").trim();
			String name = memberService.findMemberNameByEmail(email);
			
			boolean isDelete = false;
			
			if (name.equals(commentName))
				isDelete = mentorCommentsService.delete(id, mentorId);
			
			if (isDelete) {
				out.print("<script>alert('댓글을 삭제했습니다'); location.href='readRecruit?id="+mentorId+"'; </script>");
//				doGet(request,response);
			}
			else {
				out.print("<script>alert('권한이 필요합니다.'); history.back(); </script>");
			}
		}
	}

}
