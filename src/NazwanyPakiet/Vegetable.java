package NazwanyPakiet;

public class Vegetable extends Eatable{

    private float weight;

    public Vegetable(String name, float value, int daysToExpiration, float weight) {
        super(name, value, daysToExpiration);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return   "Id: " + getId() + ",\t" +
                " Vegetable" + ",\t\t" +
                " name: " + getName()+ ",\t" +
                " value: " + getValue()+ "PLN,\t" +
                " Days to expiration: " + getDaysToExpiration() + ",\t" +
                " weight: " + weight + "kg";
    }

    @Override
    public void sell() {
        setIncome(getIncome() + getValue() * this.weight);
    }

    @Override
    public boolean willItBeNonEatableAfterXdays(int daysNumber) {
        return !(getDaysToExpiration() - daysNumber >=0);
    }
}
