package NazwanyPakiet;

import DrugiPakiet.ToolSize;

public class GardenTool extends NonEatable{

    private ToolSize sizeCategory;
    private float length;
    private float wide;
    private float height;

    public GardenTool(String name, float value, boolean isFromPoland, float length, float wide, float height) {
        super(name, value, isFromPoland);
        this.length = length;
        this.wide = wide;
        this.height = height;

        if(length * wide * height > 100000){
            sizeCategory = ToolSize.large;
        } else if (length * wide * height > 10000) {
            sizeCategory = ToolSize.medium;
        } else {
            sizeCategory = ToolSize.small;
        }
    }

    public ToolSize getSizeCategory() {
        return sizeCategory;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWide() {
        return wide;
    }

    public void setWide(float wide) {
        this.wide = wide;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + ",\t" +
                " GardenTool" + ",\t" +
                " name: " + getName() + ",\t" +
                " value: " + getValue() + "PLN,\t" +
                " Is this product from Poland?: " + getIsFromPoland() + ",\t" +
                " length: " + this.length +  "cm\t" +
                " wide: " + this.wide + "cm\t" +
                " height: " + this.height + "cm\t" +
                " size category: "  + sizeCategory.name();
    }

}
