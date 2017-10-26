import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by thomas on 17-06-21.
 */
public class Skeleton implements Runnable {

    private Socket socket;
    private Object object;

    public Skeleton(Socket socket, Object object) {
        this.socket = socket;
        this.object = object;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream is = new ObjectInputStream(this.socket.getInputStream());
            Message message = (Message)is.readObject();
            String methodName = (String)message.getObject();
            Object[] args = (Object[])message.getArgs();

            Method method = null;
            if (args != null) {
                Class[] types = new Class[args.length];
                for (int i = 0; i < types.length; i++) {
                    types[i] = args[i].getClass();
                }
                method = this.object.getClass().getMethod(methodName, types);
            } else {
                method = this.object.getClass().getMethod(methodName, (Class[])null);
            }

            Object result = method.invoke(this.object, args);
            Message resultMessage = new Message(result, null);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(resultMessage);
            os.flush();
            os.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
