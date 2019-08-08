package duomenys.web.kavine;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProduktasJDBCTemplate implements ProduktasDAO {
	
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;	
	   
	   private List<Produktas> list_produktai;
	   private Produktas[] produktai;
	   private int kiek_produktu;
	   private int nr_produkto =  0;
	   
	   public void pradeti() {
		   
		   list_produktai = listProduktai();
		   produktai = list_produktai.toArray( new Produktas [ 0 ] );
		   
		   kiek_produktu = produktai.length;
		   nr_produkto = 0;
	   }

	/*	public boolean nuskaitytasFragmentas() {
			
			return nr_produkto < kiek_produktu;
		}
		
		public void skaitytiFragmenta() {
			
			nr_produkto++;
		}
		
/*		public Produktas paimtiFragmenta() {
			
			return 	
				produktai [ nr_produkto ] 
			;		
				
		} */
	   
	   public void setDataSource(DataSource ds) {
		   
		   dataSource = ds;
		   this.jdbcTemplateObject = new JdbcTemplate(dataSource);		   
	   }
	   
	   public Produktas getProduktas(Integer id) {
		   
		      String SQL = "select * from produktai where id = ?";
		      Produktas produktas = jdbcTemplateObject.queryForObject(
		    	SQL, 
		         new Object[]{id}, new ProduktasMapper());
		      
		      return produktas;		   
	   }
	   
	   public List<Produktas> listProduktai() {

	    	String SQL = "select * from produktai";
	    	List <Produktas> produktai = jdbcTemplateObject.query(
	    			SQL
	    			, new ProduktasMapper()
	    	);
	    	return produktai;
	   }

}