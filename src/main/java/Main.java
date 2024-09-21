import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    // Uncommented block to pass the first stage
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    int port = 6379;  // Port to listen on

    try {
      serverSocket = new ServerSocket(port);
      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);
      System.out.println("Server is listening on port " + port);
      
      // Wait for connection from client.
      clientSocket = serverSocket.accept();
      System.out.println("Client connected");

    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    } finally {
      try {
        if (clientSocket != null) {
          clientSocket.close();
          System.out.println("Client socket closed");
        }
        if (serverSocket != null) {
          serverSocket.close();
          System.out.println("Server socket closed");
        }
      } catch (IOException e) {
        System.out.println("IOException while closing sockets: " + e.getMessage());
      }
    }
  }
}
