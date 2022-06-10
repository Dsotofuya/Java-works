package edu.uptc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.AccountStateType;
import edu.uptc.entity.Resident;
import edu.uptc.model.Manager;

@WebServlet("/ChangeStatusAccountServlet")
public class ChangeStatusAccountServlet extends HttpServlet{
	private static final long serialVersionUID = -2537815134105163184L;

	public ChangeStatusAccountServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Manager manager = new Manager();
			request.getSession().setAttribute("residentsList", manager.fetchResidents());
			request.getSession().setAttribute("stateAccountList", manager.fetchStateAccounts());
			request.getRequestDispatcher("/changeStatusResident.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Manager manager = new Manager();
		Resident resident = manager.findResident(req.getParameter("residentSelector"));
		resident.setAccountStateType(AccountStateType.valueOf(req.getParameter("stateSelector")));
		if (manager.updateResident(resident) == true) {
			PrintWriter out;
			 out = resp.getWriter();
			 resp.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Editar residente</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>el residente ha sido adicionada exitosamente!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			 out.println("</body></html>");
		}else {
			PrintWriter out;
			 out = resp.getWriter();
			 resp.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Editar residente</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa </h1>");
			 out.println("<h2><a href=\"index.jsp\"> POR LA CHUCHA </h2>");
			 out.println("</body></html>");
		}
	}
}

