package persistance;

public interface GenericRepository<T> {
    public void add(T x);

    public T get(int id);

    public void delete(T x);

    public int getSize();
}
