package publisher.web;



import java.io.IOException;
import java.io.Writer;
//below imports not used any more as DAO is used
/*import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

import publisher.data.NewsItem;
import publisher.data.NewsItemDAO;



public class NewsFeedServlet extends HttpServlet
{
	private Logger logger = Logger.getLogger(this.getClass());
	//not used any more
	/*private static DataSource dataSource;
	
	public static void setDataSource(DataSource dataSource)
	{
	    NewsFeedServlet.dataSource = dataSource;
	}*/
	//not needed as it is old style
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("init()");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			throw new ServletException(e);
		}
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_2.0");
		feed.setTitle("My Local News Feed");
		feed.setLink("http://localhost:8080/publisher/");
		feed.setDescription("This feed was created By Sebastian Kunjappan.");
		List<SyndEntry> entries = new ArrayList<SyndEntry>();

		/*try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from news_item;");
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String url = resultSet.getString("url");
				SyndEntry entry = new SyndEntryImpl();
				entry.setTitle(title);
				entry.setLink(url);
				entries.add(entry);
			}
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
*/
		//The above block is replaced by a new block below
		List<NewsItem> newsItems = new NewsItemDAO().findAll();
		Iterator<NewsItem> it = newsItems.iterator();
		while (it.hasNext()) {
		   NewsItem newsItem = (NewsItem) it.next();
		   String title = newsItem.getTitle();
		   String url = newsItem.getUrl();
		   SyndEntry entry = new SyndEntryImpl();
		   entry.setTitle(title);
		   entry.setLink(url);
		   entries.add(entry);
		}
		resp.setContentType("text/xml");

		feed.setEntries(entries);
		Writer writer = resp.getWriter();
		SyndFeedOutput output = new SyndFeedOutput();
		try {
			output.output(feed, writer);
		} catch (FeedException e) {
			logger.error("", e);
		}
	}

}
