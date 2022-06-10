package edu.uptc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Admin;
import edu.uptc.entity.RealState;
import edu.uptc.entity.RealStateID;
import edu.uptc.model.manager;

/**
 * Servlet implementation class AddPersonaServlet
 */
@WebServlet("/AddStateServlet")
public class AddStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		String block  = request.getParameter("block");
		int internal_id = Integer.parseInt(request.getParameter("internal_id"));
		String RealStateEnum = request.getParameter("RealStateEnum");
		RealState realState = new RealState();
		RealStateID realStateID = new RealStateID(address, block, internal_id);
		realState.setRealStateEnum(edu.uptc.entity.RealStateEnum.APARTMENT);
		realState.setRealStateID(realStateID);
		Admin admin = new Admin();
		admin.setAdmin_id("1");
		admin.setAdmin_name("pepe");
		admin.setAdmin_phone("32132");
		List<RealState> realStates = new ArrayList<RealState>();
		realStates.add(realState);
		admin.setRealStates(realStates);
		realState.setAdmin(admin);
		manager m = new manager();
		boolean res=false;
		res = m.addState(realState);
		if (res) {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Add Persona</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("<style><%@include file=\"/css/vehStyle.css\"%></style></head>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>La persona ha sido adicionada exitosamente!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			 out.println("</body></html>");
		}else {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Add Persona</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("<style><%@include file=\"/css/vehStyle.css\"%></style></head>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>Error en la adición de la persona!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			 out.println("</body></html>");
		}
	}

}
