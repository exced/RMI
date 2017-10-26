import java.io.Serializable;

/**
 * Created by thomas on 17-06-21.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object object;
    private Object args;

    public Message(Object object, Object args) {
        this.object = object;
        this.args = args;
    }

    public Object getObject() {
        return this.object;
    }

    public Object getArgs() {
        return this.args;
    }
}
