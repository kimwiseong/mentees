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

import mentees.entity.Notice;
import mentees.entity.Page;
import mentees.service.MemberService;
import mentees.service.NoticeService;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final NoticeService noticeService = new NoticeService();
	private static final MemberService memberService = new MemberService();
	private static Page page;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			int total = noticeService.total();
			page = new Page(pageNum, total); 
			
			request.setAttribute("page", page);
			request.setAttribute("noticeList", noticeService.readNoticePaging(page.getAmount(), pageNum));
			
//			request.setAttribute("noticeList", noticeService.readNoticeList());
			RequestDispatcher dispatch =  request.getRequestDispatcher("noticePage.jsp");
			dispatch.forward(request, response);
		}
//		response.sendRedirect("noticePage.jsp"); 
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
		if (!email.equals("admin")) 
			out.print("<script>alert('권한이 없습니다.'); history.back(); </script>");
		
		else {
			String name = memberService.findMemberNameByEmail(email);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(email + title + content + name);
			
			boolean isInsert = noticeService.insert(new Notice(title, content, name));
			if (isInsert) {
				out.print("<script>alert('글을 등록했습니다');</script>");
				doGet(request, response);
			}
			else 
				out.print("<script>alert('글 작성에 실패했습니다'); history.back(); </script>");
		}
	}

}
