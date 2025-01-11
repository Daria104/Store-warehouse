package NazwanyPakiet;

import DrugiPakiet.IActionsInShop;

public abstract class Products implements IActionsInShop {

    private String name;
    private int id;
    private static int idNumerator;
    private float value;
    private static float income;

    public Products(String name, float value) {
        this.name = name;
        idNumerator++;
        this.id = idNumerator;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public static int getIdNumerator() {
        return idNumerator;
    }

    public static void setIdNumerator(int idNumerator) {
        Products.idNumerator = idNumerator;
    }

    public static float getIncome() {
        return income;
    }

    public static void setIncome(float income) {
        Products.income = income;
    }

    public void sell() {
        setIncome(getIncome() + getValue());
    }


    public static void possibleProducts(){
        System.out.println("1. Produkt mleczny");
        System.out.println("2. Warzywo");
        System.out.println("3. Narzędzie ogrodowe");
        System.out.println("4. Nasiona");
    }

}
