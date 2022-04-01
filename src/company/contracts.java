package company;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//singleton class
public class contracts {
    private List<String> companies;
    private static contracts contr = null;

    private contracts()
    {
        this.companies = new LinkedList<String>(Arrays.asList());
    }

    public static contracts getContracts()
    {
        if(contr == null)
            contr = new contracts();
        return contr;
    }

    public List<String> getCompanies() {
        return companies;
    }
    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }
    public void addCompay(String company)
    {
        this.companies.add(company);
    }
}
