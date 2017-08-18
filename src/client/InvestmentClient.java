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
 * Client sends the request to the server and gets the result based on the input provided
 * @author Diana Yamaletdinova
 * Aug 17, 2017
 */
public class InvestmentClient {

	public static void main(String[] args) {
		// to pinpoint the server we need to know the IP address
		String hostName = "127.0.0.1";
		// client needs to know the server's port
		int portNum = 44444;
		System.out.println("Client's Program:");
		
		// stdIn to read info from the console window
		// true in PrintWriter flushes the output buffer
		try (Socket clientSocket = new Socket(hostName, portNum);
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				InputStreamReader ir = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(ir);
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));) {

			out.println("initialize");// initialized the calculations

			// get the input from the user
			System.out.println("\n*******************************************************\n");
			System.out.println("Welcome! Enter the investment amount: ");
			out.println(stdIn.readLine());// sends data to server

			System.out.println("Great! Enter the rate in format <0.0>: ");
			out.println(stdIn.readLine());// sends data to server

			// the respond from the server
			System.out.println("Server says:" + "\n       Investment value is: " + in.readLine()
					+ "\n       Interest earned is: " + in.readLine());
		
		} catch (UnknownHostException e) {
			// if the IP address of the host is not identified
			System.out.println("Oops, Exiting...");
			System.exit(1);
		
		} catch (IOException e) {
			System.out.println("Oops, Exiting...");
			System.exit(1);
		}
	}
}
