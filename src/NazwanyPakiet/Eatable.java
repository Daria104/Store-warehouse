package NazwanyPakiet;

public abstract class Eatable extends Products {

    private int daysToExpiration;

    public Eatable(String name, float value, int daysToExpiration) {
        super(name, value);
        this.daysToExpiration = daysToExpiration;
    }

    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public abstract boolean willItBeNonEatableAfterXdays(int daysNumber);

}
