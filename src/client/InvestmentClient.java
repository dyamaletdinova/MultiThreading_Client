/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Diana Yamaletdinova
 *
 *         Aug 17, 2017
 */
public class InvestmentClient {
	
	public static void main(String[] args) {
		//to pinpoint the server we need to know the IP address 
		String hostName = "127.0.0.1";
		//client needs to know the server's port
		int portNum = 44444;
		Socket clientSocket; // the socket of the client
		
		//client needs to communicate to the server and send/receive info from it. 
		PrintWriter out;//to send info
		BufferedReader in; //to receive info
		InputStreamReader ir; //to read info in and out
		BufferedReader stdIn; // to read info from the console window
		
		try {
			
			System.out.println("I am a client:");
			clientSocket = new Socket(hostName, portNum);
			//once socket connected, perform input/output
			ir = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(ir);
			out = new PrintWriter(clientSocket.getOutputStream(),true);//flushes the output buffer
			stdIn = new BufferedReader(new InputStreamReader(System.in));//takes as the input any string input
			out.println("initialize");//initialized the calculations
			
			//get the input from the user
			System.out.println("\n*******************************************************\n");
			System.out.println("Welcome! Enter the investment amount: ");
			out.println(stdIn.readLine());//sends data to server
			
			System.out.println("Great! Enter the rate in format <0.0>: ");
			out.println(stdIn.readLine());//sends data to server
			
			System.out.println("Server says:"
					+ "\n       Investment value is: " + in.readLine()
					+ "\n       Interest earned is: " + in.readLine()
					);//the respond from the server
			
		} catch (UnknownHostException e) {
			//if the IP address of the host is not identified
			System.out.println("Oops, Exiting...");
			System.exit(1);		
		} catch (IOException e) {
			System.out.println("Oops, Exiting...");
			System.exit(1);
		}
	}
}
