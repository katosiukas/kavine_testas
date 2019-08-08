package duomenys.web.kavine;

public class Produktas {
	
	private int id;
	private String pav;
	private String mat_vnt;
	private int mat_kiek;
	private float kaina;
	private float kiekis_sand;

	public void setId( int id ) {
		
		this.id = id;
	}
	
	public int getId () {
		
		return this.id;
	}
	
	public void setPav( String pav ) {
		this.pav = pav;
	}
	
	public String getPav () {
		
		return this.pav;
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