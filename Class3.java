import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Class3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int i =0;
		pointeur tab[]=new pointeur[10];
		RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
		FileInputStream fileIn =
		         new FileInputStream("tab.dat");
		         while(fileIn.available()>0) {
		        	 ObjectInputStream input = new ObjectInputStream(fileIn);
		        	 pointeur p = (pointeur) input.readObject();
		        	 if(p!=null) {
		        	 tab[i]=p;
		        	 i++;
		        	 }else {
		        		 input.close();
		        	 }
		        	 }
		        	 fileIn.close();
		        	 Scanner scan=new Scanner(System.in);
		        	 System.out.println("entrez le numero de l'emloyee que vous voulez rechercher:");
		        	 int n=scan.nextInt();
		        	 for(i=0;i<11;i++) {
		        		 if(tab[i].num==n) {
		        			 raf.seek(tab[i].seek);
		        			 System.out.println("le nom est :"+raf.readUTF());
		        			 System.out.println("l'address est :"+raf.readUTF());
		        			 System.out.println("le SSN est :"+raf.readInt());
		        			 System.out.println("le numero est :"+raf.readInt());
		        		 }
		        		 
		        	 }
		        	 if(i==11) {
		        		 System.out.println("l'employee n'est existe pas");
		        	 }
		         
		         

	}

}
