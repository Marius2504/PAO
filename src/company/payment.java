package company;
//payment for the driver

import java.util.List;

public class payment {
    private static String formula;
    private static double taxes;
    private static List<String> listTaxes;

    public static String getFormula() {
        return formula;
    }

    public static void setFormula(String formula) {
        payment.formula = formula;
    }

    public static double getTaxes() {
        return taxes;
    }

    public static void setTaxes(double taxes) {
        payment.taxes = taxes;
    }

    public static List<String> getListTaxes() {
        return listTaxes;
    }

    public static void setListTaxes(List<String> listTaxes) {
        payment.listTaxes = listTaxes;
    }
}
