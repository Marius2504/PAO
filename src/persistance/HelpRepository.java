package persistance;

import client.help;
import employee.driver;

import java.util.ArrayList;

public class HelpRepository implements GenericRepository<help> {
    private ArrayList<help> v = new ArrayList<help>();

    @Override
    public void add(help x) {

    }

    @Override
    public help get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(help x) {
        v.remove(x);
    }

    @Override
    public int getSize() {
        return v.size();
    }
}
