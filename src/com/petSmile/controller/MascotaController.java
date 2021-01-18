package com.petSmile.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petSmile.dao.*;
import com.petSmile.model.*;
import java.util.List;
/**
 * Servlet implementation class MascotaController
 */
@WebServlet(urlPatterns = { "/mascotas" })
public class MascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MascotaController() {
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

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		}else if (opcion.equals("listar")) {
			System.out.println("Usted a presionado la opcion listar");
			
		
			MascotaDAO mascotaDAO = new MascotaDAO();
			List<Mascota> lista = new ArrayList<>();
			try {
				lista = mascotaDAO.obtenerMascotas();
				for (Mascota mascota : lista) {
					System.out.println(mascota);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("meditar")) {
			int idMascota= Integer.parseInt(request.getParameter("idMascota"));
			System.out.println("Editar id: " + idMascota);
			MascotaDAO mascotaDAO = new MascotaDAO();
			Mascota m = new Mascota();
			try {
				m = mascotaDAO.obtenerMascota(idMascota);
				System.out.println(m);
				request.setAttribute("mascota", m);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if (opcion.equals("eliminar")) {
				MascotaDAO mascotaDAO = new MascotaDAO();
				int idMascota=Integer.parseInt(request.getParameter("idMascota"));
				try {
					mascotaDAO.eliminar(idMascota);
					System.out.println("Registro eliminado satisfactoriamente...");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		

		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String opcion = request.getParameter("opcion");
		if (opcion.equals("guardar")) {
		MascotaDAO mascotaDAO = new MascotaDAO();
		Mascota mascota = new Mascota();
		mascota.setNombreMascota(request.getParameter("nombreMascota"));
		mascota.setRutDueno(request.getParameter("rutDueno"));

		try {
			mascotaDAO.guardar(mascota);
			System.out.println("Registro guardado satisfactoriamente...");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// doGet(request, response);
		} else if (opcion.equals("editar")) {
			Mascota mascota = new Mascota();
			MascotaDAO mascotaDAO = new MascotaDAO();

			mascota.setNombreMascota(request.getParameter("nombreMascota"));
			mascota.setIdMascota(Integer.parseInt(request.getParameter("idMascota")));
		
			try {
				mascotaDAO.editar(mascota);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
