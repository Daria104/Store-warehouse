package NazwanyPakiet;

public class DiaryFood extends Eatable{

    private int requiredTempOfStorage;

    public DiaryFood(String name, float value, int daysToExpiration, int requiredTempOfStorage) {
        super(name, value, daysToExpiration);
        this.requiredTempOfStorage = requiredTempOfStorage;
    }

    public int getRequiredTempOfStorage() {
        return requiredTempOfStorage;
    }

    public void setRequiredTempOfStorage(int requiredTempOfStorage) {
        this.requiredTempOfStorage = requiredTempOfStorage;
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + ",\t" +
                " DiaryFood" + ",\t\t" +
                " name: " + getName()+ ",\t" +
                " value: " + getValue()+ "PLN,\t" +
                " Days to expiration: " + getDaysToExpiration() + ",\t" +
                " requiredTempOfStorage: " + requiredTempOfStorage + "℃";


    }

    @Override
    public boolean willItBeNonEatableAfterXdays(int daysNumber) {
        return !(getDaysToExpiration() - daysNumber >=0);
    }
}
