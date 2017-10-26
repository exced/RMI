import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by thomas on 17-06-20.
 */
public class CalculatriceServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1099);
            System.out.println("Server socket listening on port 1099");
            Calculatrice calculatrice = new Calculatrice();
            while (true) {
                Socket socket = serverSocket.accept();
                Skeleton skeleton = new Skeleton(socket, calculatrice);
                Thread t = new Thread(skeleton);
                t.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
