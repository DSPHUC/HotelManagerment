package Service.iService;

import java.util.List;

public interface IBasicCRUD<T> {
    T getById(String str);

    T getById(int id);
    T getObjById(List<T> tList, String str);
    List<T> getAll();

    boolean create(T obj);
    boolean isExist(int id);

    void update(T obj);

    void delete(int id) ;
//    void display();
}
