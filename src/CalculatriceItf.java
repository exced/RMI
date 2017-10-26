/**
 * Created by thomas on 17-06-20.
 */
public interface CalculatriceItf extends Remote {
    public Float add(Float a, Float b) throws RemoteException;
    public Float multiply(Float a, Float b) throws RemoteException;
    public Float divide(Float a, Float b) throws RemoteException;
}
