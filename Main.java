//Major Agota-Piroska
//523
//maim1846

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	public static void main(String args[]) throws IOException, UnknownHostException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		//kapcsolodas a szerverre
		Socket smtp = new Socket("smtp.mailtrap.io",2525);
	
		PrintWriter out = new PrintWriter(smtp.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(smtp.getInputStream()));
	
		String localhost = InetAddress.getLocalHost().getHostName();
		
		System.out.println(in.readLine());
		out.println("HELO " + localhost);
		out.flush();
		System.out.println(in.readLine());
		System.out.print("From: ");
		String from = read.readLine();
		out.println("MAIL FROM:<" + from + ">");
		out.flush();
		System.out.println(in.readLine());
		System.out.print("To: ");
		String to = read.readLine();
		out.println("RCTP TO:<" + to + ">");
		out.flush();
		System.out.println(in.readLine());
		out.println("DATA");
		out.flush();
		System.out.println(in.readLine());
		out.println("From:<" + from + ">");
		out.println("To:<" + to + ">");
		out.println("Cc:");
		out.println("Date: Tue, 14 April 2020 17:38:43 -0500");
		System.out.print("Subject: ");
		String subject = read.readLine();
		out.println("Subject: " + subject);
		out.println();
		System.out.print("Text: ");
		String text = read.readLine();
		while ((text = read.readLine()).equals(".")) {
			out.println(text);
		}
		out.flush();
		out.println(".");
		out.flush();
		System.out.println(in.readLine());
		out.println("QUIT");
		out.flush();
		System.out.println(in.readLine());
		System.out.println("Done");
		smtp.close();
		out.close();
		in.close();
	}
	
}
