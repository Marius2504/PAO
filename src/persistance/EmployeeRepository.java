package persistance;

import company.employee;

import java.util.ArrayList;

public class EmployeeRepository implements GenericRepository<employee> {
    private ArrayList<employee> v = new ArrayList<employee>();
    @Override
    public void add(employee x) {
        v.add(x);
    }

    @Override
    public employee get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(employee x) {
        v.remove(x);

    }

    @Override
    public int getSize() {
        return v.size();
    }
}
