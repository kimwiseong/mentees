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

import mentees.service.NoticeService;

/**
 * Servlet implementation class DeleteNoticeController
 */
@WebServlet("/deleteNotice")
public class DeleteNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final NoticeService noticeService = new NoticeService();
       
    
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
			request.setAttribute("noticeList", noticeService.readNoticeList());
			RequestDispatcher dispatch =  request.getRequestDispatcher("noticePage.jsp");
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
			int id = Integer.parseInt(request.getParameter("id"));
			
			boolean isDelete = false;
			
			if (email.equals("admin")) 
				isDelete = noticeService.deleteById(id);
			if (isDelete) {
				out.print("<script>alert('삭제했습니다.'); location.href='notice'; </script>");
			}
			else {
				out.print("<script>alert('삭제 권한이 필요합니다.'); history.back(); </script>");
			}
		}
	}

}
