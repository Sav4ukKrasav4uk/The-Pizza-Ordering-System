public class Topping extends Pizza{
    private String toppingName;
    private String spiceLevel;
    private String description;

    public Topping(){}

    public Topping(String toppingName, String spiceLevel, String description){
        this.toppingName = toppingName;
        this.spiceLevel = spiceLevel;
        this.description = description;
    }

    public String getToppingName(){
        return toppingName;
    }
    public String getSpiceLevel(){
        return spiceLevel;
    }
    public String getDescription(){
        return description;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }
    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Topping[toppingName=" + toppingName + ", spiceLevel=" + spiceLevel + ", description=" + description + "]";
    }
}
