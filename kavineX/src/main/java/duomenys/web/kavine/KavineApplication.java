package duomenys.web.kavine;

// import static org.junit.Assert.assertArrayEquals;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class KavineApplication {

	public static void main(String[] args) {
		
		// SpringApplication.run( KavinexApplication.class, args );
		
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
	
		UzsakymaiOrg uzsakymai = (UzsakymaiOrg) context.getBean( "uzsakymai" );
		uzsakymai.nuskaityti(); // tik ivedimas
		uzsakymai.ruostiPatiekalus();
		uzsakymai.patiekti();
		uzsakymai.isnesioti(); 							// tik išvedimas		

		
	
/*		int[] suskaiciuoti_laikai = { 0 , 0 , 20 , 35 , 45 , 0 , 0 , 60 , 75 , 85 , 0 , 100 };
		int[] gauti_laikai = new int [uzsakymai.kiek_patiekalu];
		
		int i=0;
    	while (i < uzsakymai.kiek_patiekalu) {
    		
    		gauti_laikai[i] = uzsakymai.patiekalai[i].trukmeRuosimo();
    		i++;
    	}
    	
    	assertArrayEquals("klaida", suskaiciuoti_laikai, gauti_laikai);
    	
*/		
   
		/*		
		pagal:
		
		https://www.tutorialspoint.com/spring/spring_jdbc_example.htm 
		
	    UzsakymasJDBCTemplate uzsakymasJDBCTemplate = 
	    	         (UzsakymasJDBCTemplate)context.getBean("uzsakymasJDBCTemplate");
	    	      
	    	      System.out.println("------Listing Multiple Records--------" );
	    	      List<Uzsakymas> uzsakymai = uzsakymasJDBCTemplate.listUzsakymai();
	    	      
	    	      for (Uzsakymas record : uzsakymai) {
	    	         System.out.print("ID : " + record.getId() );
	    	         System.out.print(", Pav : " + record.getPav() );
	    	         System.out.println(
	    	        		", Trukme ruošimo : " 
	    	        		+ record.getTrukme_ruosimo()
	    	        );
	    	         System.out.println(
	    	        		", Trukme kaitinimo : " 
	    	        		+ record.getTrukme_kaitinimo()
	    	        );
	    */	     
    	
		((AbstractApplicationContext) context).close();
	}		
    	      
}