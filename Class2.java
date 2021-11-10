import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Class2  {


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int i=0;
		int k = 0;
		 pointeur  tab[]=new pointeur[10];
		FileInputStream fileIn =
		         new FileInputStream("emp.dat");
		
		
		RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
		while(fileIn.available()>0) {
		          ObjectInputStream input = new ObjectInputStream(fileIn);
                    employee e =  (employee) input.readObject();
          
                    if(e!=null) {
                    	
                    	raf.writeUTF(e.name);
                    	raf.writeUTF(e.address);
                    	raf.writeInt(e.SSN);
                    	raf.writeInt(e.number);
                    	 
                    	pointeur p=new pointeur(e.number,k);
                    	FileOutputStream filetab =
                  		         new FileOutputStream("tab.dat",true);
                    	ObjectOutputStream out = new ObjectOutputStream(filetab);
                    	k= (int) raf.getFilePointer();
                    	out.writeObject(p);
                    	
                    	tab[i]=p;
                    	i++;
                    }else {
                    	
                    	input.close();
                        
                    }
                    
                    }
		System.out.println(tab[1].seek);
		raf.seek(tab[1].seek);
		System.out.println(raf.readUTF());
		fileIn.close();
		System.out.println("transfert terminé avec succes");
                    
		       
		// TODO Auto-generated method stub

	}
	
	
}
