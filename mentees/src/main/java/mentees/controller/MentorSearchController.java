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

import mentees.entity.Page;
import mentees.service.MentorService;

/**
 * Servlet implementation class MentorSearchController
 */
@WebServlet("/subject")
public class MentorSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MentorService mentorService = new MentorService();
	private static Page page;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorSearchController() {
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
			String query = request.getParameter("subject");
			if (query.equals("none")) query = "";
			
			int pageNum = 1;
			if(request.getParameter("pageNum") != null) 
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			
			int total = mentorService.total();
			page = new Page(pageNum, total); 
			
			request.setAttribute("page", page);
			request.setAttribute("mentorList", mentorService.searchBySubjectPaging(query, page.getAmount(), pageNum));
		
			RequestDispatcher dispatch =  request.getRequestDispatcher("mentoRecruitmentPage.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
