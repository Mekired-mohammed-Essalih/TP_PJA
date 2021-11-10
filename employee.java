import java.io.Serializable;

public class employee implements Serializable {

	   public String name;
	   public String address;
	   public int SSN;
	   public int number;
	
	public employee(String name,String address,int ssn,int number) {
		this.name=name;
		this.address=address;
		this.SSN=ssn;
		this.number=number;
	}
	public String getnom() {
		return name;
	}
}
