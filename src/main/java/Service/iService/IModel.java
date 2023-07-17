package Service.iService;

public interface IModel<T> {
    int getId();

    String getName();
    void update (T obj);
}
