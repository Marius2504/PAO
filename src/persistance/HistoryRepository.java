package persistance;

import client.history;
import employee.driver;

import java.util.ArrayList;

public class HistoryRepository implements GenericRepository<history> {
    private ArrayList<history> v = new ArrayList<history>();
    @Override
    public void add(history x) {
        v.add(x);
    }

    @Override
    public history get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(history x) {
        v.remove(x);
    }

    @Override
    public int getSize() {
        return v.size();
    }
}
