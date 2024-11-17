package entities;

public class ImportedProduct extends Product{

    private Double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(Double price, String name, Double customsFee) {
        super(price, name);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag(){
        return getName() + " $ " + totalPrice() + " (Customs Fee: $ " + customsFee + ")";
    }

    public Double totalPrice(){
        return (getPrice() + customsFee);
    }
}
