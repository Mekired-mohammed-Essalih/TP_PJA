import java.util.Scanner;
import java.util.stream.Stream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class TestServeurTCP {

    public static void treatClient(Socket c){
        PrintWriter out = null;
        String clientInput = null;
        BufferedReader input = null;
        try {
            out = new PrintWriter(c.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(c.getInputStream()));
            Scanner sc = new Scanner(System.in);

            clientInput = input.readLine();
            while (!clientInput.equals("QUIT")){
            	if(clientInput.startsWith("LIST")) {
            		String word="C:\\Users\\Admin\\eclipse-workspace\\";
            		Path path=Paths.get(word+clientInput.substring(5));
            		System.out.println(path.getFileName());
            		try(Stream<Path>subfiles=Files.walk(path,1)){
            			subfiles.forEach(System.out::println);
            		}catch(IOException e) {
            			e.printStackTrace();
            		};
            		
            	}
            	if(clientInput.startsWith("GET")) {
            		String line;
            		BufferedReader br =null;
            		try {
            		br= new BufferedReader(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\" + clientInput.substring(3)));
            		
            		try {
            		while((line=br.readLine())!=null) {
            			System.out.println(line);
            		}
            		}catch(IOException e) {
            			e.printStackTrace();
            		}
            		}catch(FileNotFoundException fnf){
            			System.out.println("file not found");
            			
            		}
            	}
                System.out.println("Client input : "+ clientInput);
                out.println(sc.nextLine());// envoi depuis le serveur
                clientInput = input.readLine();// reception de la reponse du client
            }
            System.out.println("Client disconnected...");
            out.println("fin");
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
                try {
                    //input.close();
                   // out.close();
                    c.close();
                    System.out.println("Client Socket is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void main(String[] args)
    {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();
                treatClient(socket);
            }
        } catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }



}