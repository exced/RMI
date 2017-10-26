/**
 * Created by thomas on 17-06-20.
 */
public class Calculatrice implements CalculatriceItf {
    @Override
    public Float add(Float a, Float b) {
        return a + b;
    }

    @Override
    public Float multiply(Float a, Float b) {
        return a * b;
    }

    @Override
    public Float divide(Float a, Float b) {
        return a / b;
    }
}
