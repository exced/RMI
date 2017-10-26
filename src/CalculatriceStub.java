/**
 * Created by thomas on 17-06-20.
 */

public class CalculatriceStub extends Stub implements CalculatriceItf {

    public CalculatriceStub(String ip, int port) {
        super(ip, port);
    }

    @Override
    public Float add(Float a, Float b) throws RemoteException {
        Float result = null;
        try {
            Message message = this.buildMessage("add", a, b);
            result = (Float)this.invokeMethod(message);
        } catch (Exception e) {
            throw new RemoteException("RemoteException " + e.getMessage());
        }
        return result;
    }

    @Override
    public Float multiply(Float a, Float b) {
        Float result = null;
        try {
            Message message = this.buildMessage("multiply", a, b);
            result = (Float)this.invokeMethod(message);
        } catch (Exception e) {
            System.out.println("RemoteException " + e.getMessage());
        }
        return result;
    }

    @Override
    public Float divide(Float a, Float b) {
        Float result = null;
        try {
            Message message = this.buildMessage("divide", a, b);
            result = (Float)this.invokeMethod(message);
        } catch (Exception e) {
            System.out.println("RemoteException " + e.getMessage());
        }
        return result;
    }
}
