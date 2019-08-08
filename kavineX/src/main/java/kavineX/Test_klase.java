package kavineX;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import duomenys.web.kavine.*;
 

 
public class Test_klase {
 
    @Test
    public void testSarasas(){
        
    	ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
    	
		UzsakymaiOrg uzsakymai = (UzsakymaiOrg) context.getBean( "uzsakymai" );
		uzsakymai.nuskaityti(); // tik ivedimas
		uzsakymai.ruostiPatiekalus();
	//	uzsakymai.patiekti();
	//	uzsakymai.isnesioti(); 
    	
    	
    	
    	int[] suskaiciuoti_laikai = { 0 , 0 , 20 , 35 , 45 , 0 , 0 , 60 , 75 , 85 , 0 , 100 };
		int[] gauti_laikai = new int [12];
		
		System.out.println(uzsakymai.kiek_patiekalu);
		
		int i=0;
    	while (i < uzsakymai.kiek_patiekalu) {
    		
    		gauti_laikai[i] = uzsakymai.patiekalai[i].trukmeRuosimo();
    		i++;
    	}
    	
    	assertArrayEquals("klaida", suskaiciuoti_laikai, gauti_laikai);
    	
    	
    	((AbstractApplicationContext) context).close();
    	
    	
    	/* 	Integer[] suskaiciuoti_laikai = { 0 , 0 , 20 , 35 , 45 , 0 , 0 , 60 , 75 , 85 , 0 , 100 };
    	
    //	ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
    	UzsakymaiOrg uzsakymai = new UzsakymaiOrg(); // context.getBean( "uzsakymai" );
    	
    	Integer[] gauti_laikai= {100};
    	
    	int i=0;
    	while (i < uzsakymai.kiek_patiekalu) {
    		gauti_laikai[i] = uzsakymai.patiekalai[i].trukmeRuosimo();
    		i++;
    	}
    	
    	System.out.println(uzsakymai.kiek_patiekalu);
    	System.out.println(suskaiciuoti_laikai[0]);
    	System.out.println(gauti_laikai[0]);
    	
    	assertArrayEquals("klaida", suskaiciuoti_laikai, gauti_laikai);   	
    	*/
    	
   // System.out.println(uzsakymai.patiekalai[0].trukmeRuosimo());
    	
    	
    	
    //	SkaitymasIsFailo dsf = new SkaitymasIsFailo();
    //	dsf.setFile_line( "Kava Juoda" );
    //	System.out.println(uzsak.patiekalas(uzsakymas2Patiekalas));
    //	System.out.println(ruosiamas_laikas);
    //	assertEquals("Klaida", patiekalas, uzsakymai );
    	
    	
    	
   //     assertArrayEquals("Klaida duomenyse", expected , actual); 
    } 
}