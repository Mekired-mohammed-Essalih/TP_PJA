
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Class1  {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* class Employee implements Serializable 
		{
		   public String name;
		   public String address;
		   public transient int SSN;
		   public int number;
		
		public Employee(String name,String address,int ssn,int number) {
			this.name=name;
			this.address=address;
			this.SSN=ssn;
			this.number=number;
		}
		   
		}*/
		
		System.out.println("entrez le nombre de employee");
		Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        int i=1;
      //  ArrayList<employee> emps=new ArrayList<>();
        for(i=1;i<x+1;i++) {
        	System.out.println("donnee le nom de emplyee"+i);
        	scan.nextLine();
   		 String a=scan.nextLine();
   		 
   		 System.out.println("donnee l'addres de l'employee"+i);
		 String b=scan.nextLine();
		 System.out.println("donnee SSN l'employee");
		 int c=scan.nextInt();
		 System.out.println("donnee numero de l'employee");
		 int d=scan.nextInt();
		 employee e= new employee(a,b,c,d);
		 
		 //emps.add(e);
		 // File sourceFile = new File("emp.text");
		  

		 //DataOutputStream output =
			//        new DataOutputStream(new FileOutputStream("emp.text"));
		 //output.writeUTF(a);
		 //output.writeUTF(b);
		 //output.writeInt(c);
		// output.writeInt(d);
		 FileOutputStream fileOut =
		         new FileOutputStream("emp.dat",true );
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(e);
		         out.close();
		         fileOut.close();
        }
        
		         
	}
	

}
