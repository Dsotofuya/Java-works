package edu.uptc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.RealStateID;
import edu.uptc.entity.Reservation;
import edu.uptc.entity.Resident;
import edu.uptc.model.Manager;

/**
 * Servlet implementation class AddReservationServlet
 */
@WebServlet("/AddReservationServlet")
public class AddReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReservationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager manager = new Manager();
		request.getSession().setAttribute("residentsList", manager.fetchResidents());
		request.getSession().setAttribute("realStatesList", manager.fetchCommunityPlaces());
		request.getRequestDispatcher("/addReservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager manager = new Manager();

		int reservation_id = Integer.parseInt(request.getParameter("reservation_id"));

		Resident resident = manager.findResident(request.getParameter("residentSelector"));
		
		java.sql.Date reservation_date = java.sql.Date
				.valueOf("2021-" + request.getParameter("monthSelector") + "-" + request.getParameter("daySelector"));

		String starting_hour = request.getParameter("startinHourSelector");
		Time timeStart = convertStringToSQLTime(request.getParameter(String.valueOf(
				Integer.valueOf(starting_hour) + Integer.valueOf(request.getParameter("hoursAmountSelector")))));

		Time timeEding = convertStringToSQLTime(request.getParameter("startinHourSelector"));

		RealStateID realStateID = new RealStateID();
		String address = request.getParameter("addressSelector");
		String block = request.getParameter("blockSelector");
		int internalID = Integer.parseInt(request.getParameter("internalIDSelector"));
		
		realStateID.setAddress(address);
		realStateID.setBlock(block);
		realStateID.setInternal_id(internalID);
		

		Reservation reservation = new Reservation(reservation_id, resident, reservation_date, timeEding, timeStart, realStateID);
		resident.setReservation(reservation);
		System.out.println(resident.toString());

		if (manager.addReservation(reservation) == true) {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Editar residente</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>la reservación ha sido adicionada exitosamente!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			 out.println("</body></html>");
		}else {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
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

	private Time convertStringToSQLTime(String text) {
		Time time = null;
		try {
			Date timeFormat = new SimpleDateFormat("HH:mm").parse(text + ":00");
			System.out.println(timeFormat);
			time = new Time(timeFormat.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;

	}
}
