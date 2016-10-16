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
public class bookService {
	public static List <Book> books = new ArrayList<Book>();
    private static Connection getConn() {
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
    public static List <Book> findBook(String authorID) {
        Connection conn = authorService.getConn();
        String sql = "select * from books";
        PreparedStatement pstmt;
        System.out.println("finding...");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            Book tmp = null;
            books = new ArrayList<Book>();
            while(rs.next()){
            	//System.out.println("Id="+authorID+"   "+rs.getString(3));
                if(rs.getString(3).equals(authorID))
                {
                	tmp = new Book();
                	tmp.setAuthorID(rs.getString("authorID"));
                	tmp.setISBN(rs.getString("ISBN"));
                	tmp.setTitle(rs.getString("title"));
                	tmp.setPublisher(rs.getString("publisher"));
                	tmp.setPublishDate(rs.getString("publishDate"));
                	tmp.setPrice(rs.getFloat("price"));
                	books.add(tmp);
                	
                	//ServletActionContext.getRequest().setAttribute("display", author);
                    
                }
              
            }
            if (books!=null) return books;
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List <Book> findOneBook(String title) {
        Connection conn = authorService.getConn();
        String sql = "select * from books";
        PreparedStatement pstmt;
        System.out.println("finding...");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            Book tmp = null;
            books = new ArrayList<Book>();
            while(rs.next()){
            	//System.out.println("Id="+authorID+"   "+rs.getString(3));
                if(rs.getString(2).equals(title))
                {
                	tmp = new Book();
                	tmp.setAuthorID(rs.getString("authorID"));
                	tmp.setISBN(rs.getString("ISBN"));
                	tmp.setTitle(rs.getString("title"));
                	tmp.setPublisher(rs.getString("publisher"));
                	tmp.setPublishDate(rs.getString("publishDate"));
                	tmp.setPrice(rs.getFloat("price"));
                	books.add(tmp);
                	
                	//ServletActionContext.getRequest().setAttribute("display", author);
                    
                }
              
            }
            if (books!=null) return books;
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int deleteBook(String ISBN) {
        Connection conn = authorService.getConn();
        String sql = "delete from books	where ISBN = ?";
        PreparedStatement pstmt;
        System.out.println("deleting...");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1, ISBN);
            if (pstmt.executeUpdate()!=0){
            	pstmt.close();
                conn.close();
                return 1;
            }
            pstmt.close();
            conn.close();
            return -1;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
