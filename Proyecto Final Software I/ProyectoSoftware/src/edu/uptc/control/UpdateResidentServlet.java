package edu.uptc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Resident;
import edu.uptc.model.Manager;

/**
 * Servlet implementation class UpdateResidentServlet
 */
@WebServlet("/UpdateResidentServlet")
public class UpdateResidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateResidentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager manager = new Manager();
		String residentID = request.getParameter("residentIDSelector");
		if (request.getParameter("searchResidentByIDButton") != null) {
			request.getSession().setAttribute("onUpdateResident", manager.findResident(residentID));
			request.getRequestDispatcher("/updateResident.jsp").forward(request, response);
		} else {
			String residentName = request.getParameter("residentNameInput");
			String residentLastName = request.getParameter("residentLastNameInput");
			String residentPhoneNumber = request.getParameter("residentPhoneNumberInput");

			Resident resident = new Resident();
			resident.setResident_id(residentID);
			resident.setResident_name(residentName);
			resident.setResident_last_name(residentLastName);
			resident.setResident_phone_number(residentPhoneNumber);
			resident.setAccountStateType(manager.findResident(residentID).getAccountStateType());
			manager.updateResident(resident);
		}
	}
}
