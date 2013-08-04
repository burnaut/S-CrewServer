/**
 * 
 */
package screwserver;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sebastian
 *
 */
public class Serverpart {

	/**
	 * 
	 */
	public void neuersqlclient(){
		Connection con=null;
		Statement stmnt = null;
		ResultSet rs=null;
		int columnIndex = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ende try catch
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ende try catch
	try {
		stmnt= con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	
	String query = "SHOW DATABASES";
	try {
		rs= stmnt.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	try {
		while(rs.next())
		System.out.println(rs.getString(columnIndex));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	
	
	}
	
	@SuppressWarnings("unchecked")
	public void neuerserversocket(int port){
		ServerSocket serversocket= null;
		Socket clientside = null;
		FileWriter fw = null;
		PrintWriter pw=null;
		FileReader fr=null;
		BufferedReader br=null;
		InputStream i=null;
		OutputStream o=null;
		ObjectInputStream ois=null;
		char[] cbuf = new char [1000];
		HashMap<String,Number> anzahluser = null;
		try {
			serversocket = new ServerSocket(port);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			clientside = serversocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Zu Testzwecken ausgehebelt da es blockiert :)
	//Ende try catch
	
	try {
		i= clientside.getInputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	try {
	     o=clientside.getOutputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	
	try {
		fw= new FileWriter("Essensliste1.txt");
		fr=new FileReader("Essensliste1.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	pw= new PrintWriter(fw);
	pw.write("Hello this is a test");
	pw.flush();
	br=new BufferedReader(fr);
	
	
	for(int x=0; x<cbuf.length;x++){
		try {
			
			br.read(cbuf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Ende try catch
	}
	
	for (int y=0; y<cbuf.length;y++){
		System.out.println(cbuf[y]);
	}
	try {
		ois= new ObjectInputStream(i);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Ende try catch
	try {
		anzahluser=(HashMap<String, Number>) ois.readObject();
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(anzahluser);
	try {
		clientside.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		

	public void bildereinspeichern(){
		BufferedImage img = null;
		File f =new File("C:/Users/Sebastian/Desktop/andr.jpg");
		try {
			img= ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(img);
		
		
	}
	public void neuehashtabelle_für_bilder_zum_testen(){
		
		HashMap anzahl=new HashMap<String,Number>();
		HashMap hmuser= new HashMap<String,String>();
		
		
	}
}
