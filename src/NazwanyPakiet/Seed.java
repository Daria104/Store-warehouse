package NazwanyPakiet;

public class Seed extends NonEatable{

    private float weightInPackage;

    public Seed(String name, float value, boolean isFromPoland, float weightInPackage) {
        super(name, value, isFromPoland);
        this.weightInPackage = weightInPackage;
    }

    public float getWeightInPackage() {
        return weightInPackage;
    }

    public void setWeightInPackage(float weightInPackage) {
        this.weightInPackage = weightInPackage;
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + ",\t" +
                " Seed" + ",\t\t\t" +
                " name: " + getName()+ ",\t" +
                " value: " + getValue()+ "PLN,\t" +
                " Is this product from Poland?: " + getIsFromPoland() + ",\t" +
                " weight in package: "  + weightInPackage + "kg";

    }

}
