package persistance;

import employee.car;

import java.util.ArrayList;

public class CarRepository implements GenericRepository<car> {
    private ArrayList<car> v = new ArrayList<car>();
    @Override
    public void add(car x) {
        v.add(x);
    }

    @Override
    public car get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(car x) {
        v.remove(x);

    }

    @Override
    public int getSize() {
        return v.size();
    }
}
