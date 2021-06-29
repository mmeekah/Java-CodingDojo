package ProjectClass;

public class Project {
    private String name;
    private String description;
    private static String defaultName = "Default Name";
    private static String defaultDescription = "Default Description";
    private double initialCost = 0;

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(double cost) {
        initialCost = cost;
    }
    // Constructors

    public Project() {
        name = defaultName;
        description = defaultDescription;
    }

    public Project(String name) {
        this.name = name;
        description = defaultDescription;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        initialCost = cost;
    }

    // Methods
    public String elevatorPitch() {
        return this.name + "($" + this.initialCost + "): " + this.description;
    }
}
