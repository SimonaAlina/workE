package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.MYSQLManager;
import model.User;

@WebServlet(urlPatterns = "/create")
public class CreateUser extends HttpServlet {

	private static final long serialVersionUID = 3963233488095447584L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/CreateUser.jsp").forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(username, password, email);
		saveUser(request, user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void saveUser(HttpServletRequest request, User user) {
		final ServletContext ctx = request.getServletContext();
		MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");
		try {
			dbManager
					.getConnection().prepareStatement("insert into users (username, password, email) values('"
							+ user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "');")
					.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
