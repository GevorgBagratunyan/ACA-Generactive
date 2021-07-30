package storage;

import java.util.Optional;

public interface CRUD<T> {
    T create(T t);
    Optional<T> read(int ID);
    T update(int ID);
    T delete(int ID);
}
