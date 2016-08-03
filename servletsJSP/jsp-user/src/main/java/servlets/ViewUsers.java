package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.MYSQLManager;
import model.User;

@WebServlet(urlPatterns = "/view")
public class ViewUsers extends HttpServlet {

	private static final long serialVersionUID = -255456630757032267L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("usersList", findUsers(request));
		request.getRequestDispatcher("/ViewUsers.jsp").forward(request, response);
	}

	protected List<User> findUsers(HttpServletRequest request) {
		final List<User> userList = new ArrayList<User>();

		final ServletContext ctx = request.getServletContext();
		MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");

		ResultSet rs;
		try {
			rs = dbManager.getConnection().prepareStatement("select * from users;").executeQuery();

			while (rs.next()) {
				final User user = new User(rs.getString(2), rs.getString(3), rs.getString(4));
				user.setId(rs.getLong(1));
				System.out.println(user);
				userList.add(user);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
