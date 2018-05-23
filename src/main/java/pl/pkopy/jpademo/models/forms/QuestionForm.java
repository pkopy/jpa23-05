package pl.pkopy.jpademo.models.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class QuestionForm {

    @Size(min = 13, max =  13)
    private String barcode;
    @Max(25)
    private String companyName;
    @Max(25)
    private String productName;
    private int weight;

    public QuestionForm() {
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
