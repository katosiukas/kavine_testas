package duomenys.web.kavine;

import java.util.List;
import javax.sql.DataSource;

public interface ProduktasDAO {
	
	public void setDataSource(DataSource ds);
    
	public Produktas getProduktas(Integer id);

	public List<Produktas> listProduktai();  
}