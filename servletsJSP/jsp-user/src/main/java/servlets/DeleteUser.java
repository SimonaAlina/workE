package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.MYSQLManager;
import model.User;


@WebServlet(urlPatterns = "/delete")
public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1891252478053837096L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getParameter("id"));
		final User user = findUserById(request, userId);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/DeleteUser.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("userId"));
		deleteUser(request, id);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected User findUserById(HttpServletRequest request, long userId) {
		final ServletContext ctx = request.getServletContext();
		MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");
		
		User user = null;
		ResultSet rs;
		try {
			rs = dbManager.getConnection().prepareStatement("select * from USERS where ID='" + userId + "';")
					.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString(2), rs.getString(3), rs.getString(4));
				user.setId(rs.getLong(1));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	protected void deleteUser(HttpServletRequest request, long userId) {
		final ServletContext ctx = request.getServletContext();
		MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");
		PreparedStatement ps;
		try {
			ps = dbManager.getConnection()
					.prepareStatement("DELETE FROM users WHERE `id` = ?;");
			ps.setLong(1, userId);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
