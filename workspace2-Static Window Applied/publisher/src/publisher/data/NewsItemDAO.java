package publisher.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NewsItemDAO extends DataAccessObject
{
	
	private NewsItem read(ResultSet rs) throws SQLException {
		   Long id = new Long(rs.getLong("id"));
		   String title = rs.getString("title");
		   String url = rs.getString("url");
		   NewsItem newsItem = new NewsItem();
		   newsItem.setId(id);
		   newsItem.setTitle(title);
		   newsItem.setUrl(url);
		   return newsItem;
		}
	
	public List<NewsItem> findAll() {
		   LinkedList<NewsItem> newsItems = new LinkedList<NewsItem>();
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from news_item order by id";
		      statement = connection.prepareStatement(sql);
		      rs = statement.executeQuery();
		      while (rs.next()) {
		         NewsItem newsItem = read(rs);
		         newsItems.add(newsItem);
		      }
		      return newsItems;
		   }
		   catch (SQLException e) {
		      throw new RuntimeException(e);
		   } 
		   finally {
		      close(rs, statement, connection);
		   }
		}
	
	public NewsItem find(Long id) {
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from news_item where id=?";
		      statement = connection.prepareStatement(sql);
		      statement.setLong(1, id.longValue());
		      rs = statement.executeQuery();
		      if (!rs.next()) {
		         return null;
		      }
		      return read(rs);
		   }
		   catch (SQLException e) {
		      throw new RuntimeException(e);
		   }
		   finally {
		      close(rs, statement, connection);
		   }
		}
}
