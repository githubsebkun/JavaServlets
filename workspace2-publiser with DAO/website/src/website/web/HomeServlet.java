package website.web;
 
import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
 
public class HomeServlet extends HttpServlet {
        
       private Logger logger = Logger.getLogger(this.getClass());
        
       private RequestDispatcher homeJsp;
        
       public void init(ServletConfig config) throws ServletException {
               ServletContext context = config.getServletContext();
               homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
       }
        
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
       throws ServletException, IOException {
    	   logger.debug("Retrieving yahoo news feed");
    	  // URL url = new URL("http://rss.news.yahoo.com/rss/tech");
    	   URL url = new URL("http://localhost:8080/publisher/news.rss");
    	   SyndFeedInput syndFeedInput = new SyndFeedInput();
    	   SyndFeed syndFeed = null;
    	   XmlReader xmlReader = new XmlReader(url);
    	   try {
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException | FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   //logger.debug("Forwarding to home.jsp");
    	   
    	   //req.setAttribute("message", "bye");
    	 //  ==
    	   logger.debug("HomeServlet.doGet()");
    	   req.setAttribute("syndFeed", syndFeed);
           homeJsp.forward(req, resp);
    	  /* logger.debug("Retrieving yahoo news feed");
    	   URL url = new URL("http://rss.news.yahoo.com/rss/tech");
    	   SyndFeedInput syndFeedInput = new SyndFeedInput();
    	   SyndFeed syndFeed = null;
    	   XmlReader xmlReader = new XmlReader(url);
    	   try {
   			syndFeed = syndFeedInput.build(xmlReader);
   		} catch (IllegalArgumentException e) {
   			logger.error("", e);
   		} catch (FeedException e) {
   			logger.error("", e);
   		}
    	   logger.debug("Forwarding to home.jsp");
    	   req.setAttribute("syndFeed", syndFeed);
    	   homeJsp.forward(req, resp);*/
       }
}