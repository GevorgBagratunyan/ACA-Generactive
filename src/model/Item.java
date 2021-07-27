package model;

public abstract class Item {
    private final int id;
    private final String name;
    private final double basePrice;
    private final Group group;
    private final Configuration configuration;


    public Item(int id, String name, double basePrice, Group group, Configuration configuration) {
        this.name = name;
        this.basePrice = basePrice;
        this.group = group;
        this.id = id;
        this.configuration = configuration;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Group getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void printContent() {
        System.out.println("    Item group : " + this.group.getName());
        System.out.println("    Item name : " + this.name);
        System.out.println("    Item price : " + this.basePrice);
        System.out.println("    Item ID : " + this.id);
    }

    public abstract double calculatePrice();
}
