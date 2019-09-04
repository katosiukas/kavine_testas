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

/**
 * 
 * @author Gediminas
 * @author Internetas :)
 * <p>
 * 
 * Failo pasiemimas is WEB, naudojant HttpServlet (destytojui nelabai patiko, bet veikiantis dalykas) ir failo turinio itraukimas i mySql duomenu baze (naudojant prepared statement).
 *@see failo_pabaiga Pasitikrinimas ar failas yra CSV pletinio.
 * Prie failo pavadinimo pridedama sios dienos data ir laikas, tam kad zinoti koks tiksliai ir kada failas ikeltas.
 * Failas padedamas i konkrecia vieta diske (lokaliai).
 * Po failo turinio importavimo i duomenu baze, issisiunciam atgal i WEB pranesima, kad viskas ivyko sekmingai ir kada tai ivyko, arba kad neivyko :)
 * 
 * 
 * P.S. importu kiekis ispudingas, nes naudojama labai daug visokiu skirtingu proceduru (failo skaitymas, failo kopijavimas,  sql, data, servlet, controller.
 * P.S.S. kas liko keista, tai jog kopijuojant faila uzdetas parametras REPLACE_EXISTING bet jis neveikia, neleidzia ant virsaus uzrasyti failo su tokiu paciu pavadinimu.
 * 
 *
 */

@Controller
@WebServlet("/upload")
public class UzsakymaiImportas extends HttpServlet {
	
	@Override
	@RequestMapping(path="/upload")	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
/**
 * 	Failo paemimas is WEB
 */
		Part filePart = request.getPart("file");								// pasiimam faila is web
		InputStream fileInputStream = filePart.getInputStream();
/**
 *  Datos suformavimas failui ir atidavimui i web			    
 */
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd-HHmm");	// apsirasom datos ir laiko formata failo pavadinimui
	    	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd-HH:mm"); // toki formata atiduosim i web
	    	Date date = new Date(System.currentTimeMillis());					// pasiimam dabartine data ir laika
/**
 *  Failo vardo pataisymas pagal upload data ir laika	  	    
 */
	    	String failo_vardas = filePart.getSubmittedFileName(); 				// pasiimam failo pavadinima
	    	int taskas = failo_vardas.indexOf('.');								// randam taska failo pavadinime
	    	String failo_pradzia = failo_vardas.substring(0,taskas); 			// atskiriam failo pavadinima nuo pletinio
	    	String failo_pabaiga = failo_vardas.substring(taskas+1, taskas+4); 	// atskiriam failo pletini ( 3 simboliai po tasko)
	    	
	    	  	if (failo_pabaiga.equals("csv")) {
	    	  		
	    	  		String failas_su_data = failo_pradzia + "_" + formatter.format(date) + ".csv"; 								// pridedam data prie failo pavadinimo ir csv pletini (failas visada turi buti csv tipo)
	    	  		File fileToSave = new File("C:\\Users\\keturioliktas\\Desktop\\Spring\\kavine\\src\\" + failas_su_data); 	// formuojam kelia iki failo kur jis bus padetas
	    	  		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING); 						// kopijuojam faila i jam skirta kataloga
	    	  		
	    	  		// cia tarpinis variantas failo skaidymo y masyva
	    	  		String eilute = null;
	    	  		int T_ruosimo = 0;
	    	  		int T_kaitinimo = 0;
	    	  		try {
/** 
 *  Failo turinio kelimas i dB	    				
 */
	    				BufferedReader br = new BufferedReader( new FileReader( fileToSave ) );
	    				Class.forName("com.mysql.cj.jdbc.Driver"); 										//veikiantis irasu itraukimas i mysql
						String url = "jdbc:mysql://localhost:3306/kavine"; 								//prisijungimas prie DB
				        Connection conn = DriverManager.getConnection(url,"root",""); 	
	    				
	    					while ( ( eilute = br.readLine() ) != null ) {								// pasiskaidom faila
	    				 
	    						String[] langeliai = eilute.split ( "," );
	    						
	    						String T_pav = langeliai [ 0 ];
	    						
	    						if ( langeliai.length > 1 ) {
	    							T_ruosimo = ( Integer.parseInt( langeliai [ 1 ] ) );		
	    						}
	    						
	    						if ( langeliai.length > 2 ) {

	    							T_kaitinimo = ( Integer.parseInt( langeliai [ 2 ] ) );
	    						}	
	    						    				    
	    				        String query = " insert into uzsakymai (pav, trukme_ruosimo, trukme_kaitinimo, busena)" + " values (?, ?, ?, ?)";	 // susikuriam eilute kuria trauksim i DB
	    				        PreparedStatement preparedStmt = conn.prepareStatement(query);
	    				        
	    				        preparedStmt.setString (1, T_pav);
	    				        preparedStmt.setInt (2, T_ruosimo);
	    				        preparedStmt.setInt   (3, T_kaitinimo);
	    				        preparedStmt.setString(4, "uzsakytas");
	    				        	    				       
	    				        preparedStmt.execute();	 // ivykdom itraukima
	    					}
	    					
	    				br.close();
	    					
	    			} catch ( Exception e ) {
	    				
	    				System.err.format ( "IOException: %s%n", e );
	    			}
/**
 *  Atsakymas i WEB ar viskas paejo	    	  		
 */
	    	  		response.setContentType("text/html");  // nusistatom kad siusim txt pranesima
	    	  		response.setCharacterEncoding("UTF-8");
	    	  		response.getWriter().write("Naujas patiekalu failas importuotas. " + formatter1.format(date));	// Atiduodam pranesima kad failas sekmingai issiustas i serveri + data ir laikas
	    	  		    	  	
	    	  	} else {
	    	  		
	    	  		response.getWriter().write("Neteisingas failas, failas nesuimportuotas!"); // ne csv failo, neimam.
	    	  	}
	}	
} 