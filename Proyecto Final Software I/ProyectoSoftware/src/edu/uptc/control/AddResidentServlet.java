package edu.uptc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.AccountStateType;
import edu.uptc.entity.RealState;
import edu.uptc.entity.RealStateID;
import edu.uptc.entity.Resident;
import edu.uptc.model.Manager;

@WebServlet("/AddResidentServlet")
public class AddResidentServlet extends HttpServlet {
	private static final long serialVersionUID = -8154094589090347665L;

	public AddResidentServlet() {
		 super();
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
		Manager manager = new Manager();
		Resident resident = new Resident();
		RealStateID realStateID = new RealStateID();
		
		String resident_id = request.getParameter("resident_id");
		String resident_name = request.getParameter("resident_name");
		String resident_last_name = request.getParameter("resident_last_name");
		String resident_phone_number = request.getParameter("resident_phone_number");
		
		resident.setResident_id(resident_id);
		resident.setResident_name(resident_name);
		resident.setResident_last_name(resident_last_name);
		resident.setResident_phone_number(resident_phone_number);
		resident.setAccountStateType(AccountStateType.CREADA);
		
		String address = request.getParameter("addressSelector");
		String block  = request.getParameter("blockSelector");
		int internalID = Integer.parseInt(request.getParameter("internalIDSelector"));
		
		
		realStateID.setAddress(address);
		realStateID.setBlock(block);
		realStateID.setInternal_id(internalID);
		
		RealState realState = manager.findRealState(realStateID);
		resident.getRealStates().add(realState);
		realState.setResident(resident);
		manager.addResident(resident,realState);

	}
}
