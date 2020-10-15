package CoreJava.Generics.Simple;

public class FirstGeneric<T> {
    private T data;

    public FirstGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
