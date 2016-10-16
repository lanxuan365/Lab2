package action;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

import database.Author;
import database.Book;
import service.authorService;
import service.bookService;

public class queryAction extends ActionSupport{
	
	private String name;
	public List <Author> au = new ArrayList<Author>();
	public List <Book> bo = new ArrayList<Book>();
	public  String execute(){
		System.out.println("name="+name);
		if (findAuthor()==1)
			return "success";	
		return "error";
	}
	
    public Integer findAuthor() {
        Connection conn = authorService.getConn();
        String sql = "select * from authors";
        PreparedStatement pstmt;
        System.out.println("finding...");
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            Author tmp = null;
            while(rs.next()){
            	//System.out.println("name="+name+"   "+rs.getString(2));
                if(rs.getString(2).equals(this.name))
                {
                	tmp = new Author();
                	tmp.setAuthorID(rs.getString("authorID"));
                	tmp.setAge(rs.getInt("age"));
                	tmp.setName(rs.getString("name"));
                	tmp.setCountry(rs.getString("country"));
                	au.add(tmp);
                	if ((bo=bookService.findBook(tmp.getAuthorID()))!=null)
                	{
                		return 1;
                	}
                }
            }
            pstmt.close();
            conn.close();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
	
	public  String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}
