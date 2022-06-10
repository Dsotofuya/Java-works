package edu.uptc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.uptc.entity.RealStateID;
import edu.uptc.model.Manager;

/**
 * Servlet implementation class FindRealStateServlet
 */
@WebServlet("/FindRealStateServlet")
public class FindRealStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindRealStateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RealStateID rsid = new RealStateID(request.getParameter("realStateAddressInput"),
				request.getParameter("realStateBlockInput"),Integer.valueOf(request.getParameter("realStateInternalNumberInput")));
		Manager manager = new Manager();
		System.out.println("xd");
		System.out.println("xd mamahuevo" + manager.findRealState(rsid).toString());
	}

}
