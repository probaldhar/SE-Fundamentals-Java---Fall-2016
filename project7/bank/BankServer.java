import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


/**
   A server that executes the Simple Bank Access Protocol.
*/
public class BankServer
{  

   public static void main(String[] args) throws IOException
   {  

      //URL website = new URL("http://JavaSideKicks.com");
      final int ACCOUNTS_LENGTH = 10;
      Bank bank = new Bank(ACCOUNTS_LENGTH);
      final int SBAP_PORT = 8888;
      ServerSocket server = new ServerSocket(SBAP_PORT);
      System.out.println("Waiting for clients to connect...");
      
      while (true)
      {
         Socket s = server.accept();
         InputStream is = s.getInputStream();
          InputStreamReader isr = new InputStreamReader(is);
          BufferedReader br = new BufferedReader(isr);
          String number = br.readLine();
         System.out.println("Client connected." + " " + number);
         BankService service = new BankService(s, bank);
         Thread t = new Thread(service);
         t.start();
      }
   }
}








