package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = -5005443331085510611L;

	private String message;

	@Override
	public void init() throws ServletException {
		message = "Hello World, User!";
	}

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		final PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		out.print("<input type=\"submit\" value=\"Home\" onclick=\"window.location='/jsp-user';\" /> ");
		out.close();
	}

	@Override
	public void destroy() {
		// do nothing.
	}
}
