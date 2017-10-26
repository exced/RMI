/**
 * Created by thomas on 17-06-20.
 */
public class CalculatriceClient {

    public static void main(String[] args) {
        CalculatriceStub stub = new CalculatriceStub("localhost",1099);
        try {
            Float add = stub.add(1.f, 3.f);
            System.out.println("add(1,3) = " + add);
            Float multiply =  stub.multiply(1.f, 3.f);
            System.out.println("multiply(1,3) = " + multiply);
            Float divide = stub.divide(1.f, 3.f);
            System.out.println("divide(1,3) = " + divide);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
