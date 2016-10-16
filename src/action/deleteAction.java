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

public class deleteAction {
	private String ISBN;
	public  String execute(){
		if (service.bookService.deleteBook(getISBN())==1)
			return "success";
		return "error";
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}
