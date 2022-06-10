package edu.uptc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Persona;
import edu.uptc.model.PersonaManager;

/**
 * Servlet implementation class SelectPersonaServlet
 */
@WebServlet("/SelectPersonaServlet")
public class SelectPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaManager pm;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//String updstatus = (String) request.getSession().getAttribute("setUpdate");
				this.listPersona(request, response);
				
				//if (updstatus.equals("update")) {
				//	request.getSession().setAttribute("setUpdate", "list");
				//	response.sendRedirect(request.getContextPath() + "/updatePerson.jsp");
				//}else {
					
				//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		pm = new PersonaManager();
	 	List<Persona> lista = pm.findAllPersona();
	 	request.getSession().setAttribute("listPersona", lista);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("selPerson.jsp");
        dispatcher.forward(request, response);
     }
}
