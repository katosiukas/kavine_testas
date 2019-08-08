package kavineX;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import duomenys.web.kavine.*;

@Entity // This tells Hibernate to make a table out of this class
public class Produktai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String pav;
    private String mat_vnt;
	private int mat_kiek;
	private float kaina;
	private float kiekis_sand;
	
    public Integer getId() {
	   	return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}
	
	public void setMat_vnt( String mat_vnt ) {
		this.mat_vnt = mat_vnt;
	}
	
	public String getMat_vnt () {
		
		return this.mat_vnt;
	}
	
	public void setMat_kiek( int mat_kiek ) {
		
		this.mat_kiek = mat_kiek;
	}
	
	public int getMat_kiek () {
		
		return this.mat_kiek;
	}
	
	public void setKaina( float kaina ) {
		
		this.kaina = kaina;
	}
	
	public float getKaina () {
		
		return this.kaina;
	}
	
	public void setKiekis_sand( float kiekis_sand ) {
		
		this.kiekis_sand = kiekis_sand;
	}
	
	public float getKiekis_sand () {
		
		return this.kiekis_sand;
	}
}
