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

import mentees.service.MentorCommentsService;
import mentees.service.MentorService;

/**
 * Servlet implementation class readRecruitController
 */
@WebServlet("/readRecruit")
public class ReadRecruitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MentorService mentorService = new MentorService();
	private static final MentorCommentsService mentorCommentsService = new MentorCommentsService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadRecruitController() {
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
			int id = Integer.parseInt(request.getParameter("id"));
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
