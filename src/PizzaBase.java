public class PizzaBase extends Pizza{
    private String baseName;
    private String baseType;
    private String description;

    public PizzaBase(){}

    public PizzaBase(String baseName, String baseType, String description){
        this.baseName = baseName;
        this.baseType = baseType;
        this.description = description;
    }

    public String getBaseName(){
        return baseName;
    }
    public String getBaseType(){
        return baseType;
    }
    public String getDescription(){
        return description;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "PizzaBase[baseName=" + baseName + ", baseType=" + baseType + ", description=" + description + "]";
    }
}
