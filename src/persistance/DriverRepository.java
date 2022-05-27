package persistance;

import employee.driver;

import java.util.ArrayList;

public class DriverRepository implements GenericRepository<driver> {
    private ArrayList<driver> v = new ArrayList<driver>();

    @Override
    public void add(driver x) {
        v.add(x);
    }

    @Override
    public driver get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(driver x) {
        v.remove(x);

    }

    @Override
    public int getSize() {
        return v.size();
    }
}
