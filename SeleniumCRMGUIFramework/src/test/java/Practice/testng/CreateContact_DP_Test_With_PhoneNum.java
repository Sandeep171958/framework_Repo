package Practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test_With_PhoneNum {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String LastName, long PhoneNumber) {
		System.out.println("firstName : " + firstName +  " LastName :" + LastName + " phoneNumber :" + PhoneNumber);
	}
	
	@DataProvider
	public Object [] [] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0] ="Sandeep";
	    objArr[0][1]="hr";
	    objArr[0][2]= 8877665544l;
	    
	    objArr[1][0]="Deepak";
	    objArr[1][1]="sh";
	    objArr[1][2]=1122334455l;
	    
	    objArr[2][0]="minit";
	    objArr[2][1]="singh";
	    objArr[2][2]=4455667788l;
		
		return objArr;
		
	}

}
