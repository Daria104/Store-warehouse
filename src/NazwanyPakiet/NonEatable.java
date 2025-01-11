package NazwanyPakiet;

public abstract class NonEatable extends Products{

    private boolean isFromPoland;

    public NonEatable(String name, float value, boolean isFromPoland) {
        super(name, value);
        this.isFromPoland = isFromPoland;
    }

    public boolean getIsFromPoland() {
        return isFromPoland;
    }

    public void setIsFromPoland(boolean fromPoland) {
        isFromPoland = fromPoland;
    }
}
