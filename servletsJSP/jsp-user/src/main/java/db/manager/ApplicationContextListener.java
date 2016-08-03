package db.manager;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * The ApplicationContextListener.java.
 * @author dungureanu
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener {

	private final static ResourceBundle BUNDLE = ResourceBundle.getBundle("resourceBundle");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextInitialized(final ServletContextEvent servletContextEvent) {
		final ServletContext ctx = servletContextEvent.getServletContext();

		final String className = BUNDLE.getString("mysqldb.class");
		final String url = BUNDLE.getString("mysqldb.url");
		final String user = BUNDLE.getString("mysqldb.user");
		final String pass = BUNDLE.getString("mysqldb.pass");

		// create database connection from init parameters and set it to context
		final MYSQLManager dbManager = new MYSQLManager(className, url, user, pass);
		ctx.setAttribute("MYSQLManager", dbManager);

		System.out.println("Database connection initialized for Application.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent servletContextEvent) {
		final ServletContext ctx = servletContextEvent.getServletContext();
		final MYSQLManager dbManager = (MYSQLManager) ctx.getAttribute("MYSQLManager");
		dbManager.closeConnection();

		System.out.println("Database connection closed for Application.");
	}
}