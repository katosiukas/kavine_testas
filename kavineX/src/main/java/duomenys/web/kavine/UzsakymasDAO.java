package duomenys.web.kavine;

import java.util.List;
import javax.sql.DataSource;

public interface UzsakymasDAO {
	
	public void setDataSource(DataSource ds);
    
	public Uzsakymas getUzsakymas(Integer id);

	public List<Uzsakymas> listUzsakymai();  
}