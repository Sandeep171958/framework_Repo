package Practice.datadriventesting;

public class GenerateAlphaNumericData {

	public static void main(String[] args) {
		int n=20;
		
		String Anum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<=n;i++) {
			int index = (int)(Anum.length()*Math.random());
			
			sb.append(Anum.charAt(index));
			
		}
		System.out.println(sb);

	}

}
