package website.web;
 
 import java.io.IOException;
 import java.io.InputStream;
 import java.net.URL;
 import java.net.URLConnection;
 
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletConfig;
 import javax.servlet.ServletContext;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import org.apache.log4j.Logger;
 
 import de.nava.informa.core.ChannelIF;
 import de.nava.informa.core.ParseException;
 import de.nava.informa.impl.basic.ChannelBuilder;
 import de.nava.informa.parsers.FeedParser;
 
 public class HomeServlet extends HttpServlet {
        
        private Logger logger = Logger.getLogger(this.getClass());
        private RequestDispatcher homeJsp;
        
        public void init(ServletConfig config) throws ServletException {
                ServletContext context = config.getServletContext();
                homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        }
        
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                logger.debug("Retrieving yahoo news feed");
                URL url = new URL("http://rss.news.yahoo.com/rss/tech");
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                ChannelIF channel = null;
                try {
                        channel = FeedParser.parse(new ChannelBuilder(), is);
                } catch (IOException e) {
                        logger.error(e);
                } catch (ParseException e) {
                        logger.error(e);
                }
                logger.debug("Forwarding to home.jsp");
                req.setAttribute("channel", channel);
                homeJsp.forward(req, resp);
         }
 }