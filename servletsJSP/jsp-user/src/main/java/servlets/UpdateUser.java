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

@WebServlet(urlPatterns = "/update")
public class UpdateUser extends HttpServlet {

	private static final long serialVersionUID = 3079363272046428811L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final long userId = Long.parseLong(request.getParameter("id"));
		final User user = findUserById(request, userId);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/UpdateUser.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		long userId = Long.parseLong((String) request.getParameter("userId"));
		updateUser(request, userId);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	public User findUserById(HttpServletRequest request, long userId) {
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
	
	public void updateUser(HttpServletRequest request, long userId) {
		final ServletContext ctx = request.getServletContext();
		MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("userPass");
		String email = request.getParameter("userEmail");
		
		PreparedStatement ps;
		try {
			ps = dbManager.getConnection().prepareStatement("update USERS set username = ?, password = ?, email = ? where ID = ?;");

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setLong(4, userId);

			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
