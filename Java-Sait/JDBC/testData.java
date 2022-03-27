import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

class Item {
	String title;
	String content;
	
	Item(String title, String content){
		this.title = title;
		this.content = content;
	}
	
	String getTitle() {
		return this.title;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	String getContent() {
		return this.content;
	}
	
	void setContent(String content) {
		this.content = content;
	}
}

class Dao {
    private Connection conn;
    private static final String userName = "admin";
    private static final String passWord = "admin@123";
    //private static final String hostUrl = "jdbc:mysql://localhost/"; // 3306
    private static final String hostUrl = "jdbc:oracle:thin:@localhost:1521:"; // SID
    private static final String dbName = "XE";
    //private static final String dbName = "freeboard";
    private static final String tableName = "freeboard";
    
    Dao() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("oracle.jdbc.driver.OracleDriver");            
            conn = DriverManager.getConnection(hostUrl+dbName, userName, passWord);
            System.out.println("Loading driver success");
        } catch (Exception e) {
            System.out.println("Loading driver failed");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
    }
    
    ArrayList<Item> getAllDataTable() {
    	ArrayList<Item> list = new ArrayList<>();
    	ResultSet resultSet = null;
    	Statement statement = null;
    	
    	try {
	    	statement = conn.createStatement();
	    	
	    	// select title, content from freeboard
	    	String sql = "SELECT title, content FROM " + tableName;  
	    	resultSet = statement.executeQuery(sql);
	    	while (resultSet.next()) {
	    		String title = resultSet.getString(1);
	    		String content = resultSet.getString(2);
	    		//System.out.println(title + " : " + content);
	    		list.add(new Item(title, content));
	    	}
    	} catch (Exception e) {
            System.out.println(e);            
        }
	    
	    return list;
    }
    
    void insertData(Item item) {
    	PreparedStatement preparedStatement = null;
    	
    	try {
    		// INSERT INTO freeboard (title, content) VALUES ("a", "b");
    		String sql = String.format("INSERT INTO %s (title, content) VALUES (?, ?)", tableName);
    		preparedStatement  = conn.prepareStatement(sql);
    		preparedStatement.setString(1, item.getTitle()); // a
    		preparedStatement.setString(2, item.getContent()); // b
    		
    		int count = preparedStatement.executeUpdate();
    		if (count == 0)
    			System.out.println("Insert Failed");
    		else
    			System.out.println("Insert Success");		    	
    	} catch (Exception e) {
            System.out.println(e);            
        }
    }
}

public class OjdbcTest {
	static ArrayList<Item> list = null;
	static Scanner scan = new Scanner(System.in);
	static Dao dao = new Dao();
	
    public static void main(String[] args) {
    	System.out.println("main");    	
    	boolean run = true;
        list = dao.getAllDataTable();
        
        while(run) {
        	int menu;
        	
	        System.out.println("Menu : ");
	        System.out.println(" 1. print all");
	        System.out.println(" 2. insert data into freeboard");
	        System.out.println(" 3. exit");
	        System.out.print("Enter: ");
	        menu = scan.nextInt();
	        switch(menu) {
	        	case 1:
	        		printAll();
	        		break;
	        	case 2:
	        		scan.nextLine();
	        		System.out.print("Enter the title : ");
	        		String title = scan.nextLine();
	        		System.out.print("Enter the content : ");
	        		String content = scan.nextLine();
	        		
	        		Item item = new Item(title, content);	        		
	        		insertItem(item);
	        		list = dao.getAllDataTable();
	        		break;
	        	case 3:
	        		run = false;
	        		break;
	        }
	        System.out.println();
        }               
    }
    
    static void printAll() {
    	System.out.println();
    	System.out.println("----------");
    	System.out.println("List of Data:");
        for (Item e : list)
        	System.out.println("  " + e.getTitle() + " : " + e.getContent());        
        System.out.println("----------");
    }
    
    static void insertItem(Item item) {
    	dao.insertData(item);
    }
}