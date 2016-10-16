package service;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import database.Author;
import database.Book;
public class authorService {
    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://cazehvmfjjoo.rds.sae.sina.com.cn:10189/author";
        String username = "root";
        String password = "11111111";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static List <Author> findAuthor(String authorID) {
        Connection conn = authorService.getConn();
        String sql = "select * from authors";
        PreparedStatement pstmt;
        System.out.println("finding...");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            Author tmp = null;
            List <Author> auth = new ArrayList<Author>();
            while(rs.next()){
            	//System.out.println("Id="+authorID+"   "+rs.getString(3));
                if(rs.getString(1).equals(authorID))
                {
                	tmp = new Author();
                	tmp.setAuthorID(rs.getString("authorID"));
                	tmp.setName(rs.getString("name"));
                	tmp.setAge(rs.getInt("age"));
                	tmp.setCountry(rs.getString("country"));
                	auth.add(tmp);
                	//ServletActionContext.getRequest().setAttribute("display", author);
                }
              
            }
            return auth;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
