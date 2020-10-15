package CoreJava.Generics.Bounded;

public class BoundedGenerics<T extends Number> {
    private T data1, data2;

    public BoundedGenerics(final T data1, final T data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public void performCalc() {
        System.out.println(data1.doubleValue() + data2.doubleValue());
        System.out.println(data1.doubleValue() - data2.doubleValue());
        System.out.println(data1.doubleValue() / data2.doubleValue());
        System.out.println(data1.doubleValue() % data2.doubleValue());
    }
}
