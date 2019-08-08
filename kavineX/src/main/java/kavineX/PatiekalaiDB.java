package kavineX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;	//datai
import java.util.Date;				//datai
import javax.servlet.ServletException;	//http duomenu perdavimas
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.*;

/*@Controller
@WebServlet("/patiekalai")
public class PatiekalaiDB {
	
//	@Override
	@RequestMapping(path="/patiekalai")	
	
	public void imtiIsDb(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 										
			String url = "jdbc:mysql://localhost:3306/kavine"; 
			Connection conn = DriverManager.getConnection(url,"root",""); 	
        
			PreparedStatement stmt=conn.prepareStatement("select * from patiekalai");  
			ResultSet rs=stmt.executeQuery();  
			
			while(rs.next()){  
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2));  
			
				response.setContentType("text/html");  
    	  		response.setCharacterEncoding("UTF-8");
    	  		response.getWriter().write(rs.getString(2));	
			}  
			
		} catch ( Exception e ) {
			
			System.err.format ( "IOException: %s%n", e );
		}
	
	}
}*/