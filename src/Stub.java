import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by thomas on 17-06-21.
 */
public class Stub {

    private String ip;
    private int port;

    public Stub(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Message buildMessage(String methodName, Object... methodArgs) {
        Message message = new Message(methodName, methodArgs);
        return message;
    }

    public Object invokeMethod(Message message) throws RemoteException {
        Object object = null;
        try {
            Socket socket = new Socket(this.ip, this.port);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(message);
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            Message response = (Message)is.readObject();
            object = response.getObject();
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            throw new RemoteException("Remote Exception: " + e.getMessage());
        }
        return object;
    }
}
