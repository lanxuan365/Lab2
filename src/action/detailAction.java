package action;
import java.util.ArrayList;
import java.util.List;

import database.Author;
import database.Book;
import service.bookService;
public class detailAction {//显示详细信息action
	private String title;
	public List <Author> auth = new ArrayList<Author>();
	public List <Book> book = new ArrayList<Book>();
	public  String execute(){
		book=service.bookService.findOneBook(getTitle());
		Book tmp=book.get(0);
		auth=service.authorService.findAuthor(tmp.getAuthorID());
		return "success";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
