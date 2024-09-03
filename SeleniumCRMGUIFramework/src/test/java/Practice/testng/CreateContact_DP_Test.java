package Practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String LastName) {
		System.out.println("firstName : " + firstName + " LastName :" + LastName);
	}
	
	@DataProvider
	public Object [] [] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0] ="Sandeep";
	    objArr[0][1]="hr";
	    
	    objArr[1][0]="Deepak";
	    objArr[1][1]="sh";
	    
	    objArr[2][0]="minit";
	    objArr[2][1]="singh";
		
		return objArr;
		
	}

}
