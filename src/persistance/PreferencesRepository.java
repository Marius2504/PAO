package persistance;

import client.preferences;

import java.util.ArrayList;

public class PreferencesRepository implements GenericRepository<preferences> {
    private ArrayList<preferences> v = new ArrayList<preferences>();
    @Override
    public void add(preferences x) {
        v.add(x);
    }

    @Override
    public preferences get(int id) {
        return v.get(id);
    }

    @Override
    public void delete(preferences x) {
        v.remove(x);
    }

    @Override
    public int getSize() {
        return v.size();
    }
}
