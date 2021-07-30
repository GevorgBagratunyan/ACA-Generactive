package model;


import model.enums.Complexity;
import storage.Storage;

public class GenerativeItem extends Item {

    private final Complexity complexity;

    public GenerativeItem(GenerativeItemBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.group, builder.configuration);
        complexity = builder.complexity;
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        double price = this.getBasePrice();
        double resolutionCoefficient = configuration.getResolution().getResolutionCoefficient();
        double comp = complexity.getValue();
        return price * resolutionCoefficient * comp;
    }

    public static class GenerativeItemBuilder {
        private int id;
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;
        private Complexity complexity;

        public GenerativeItemBuilder id() {
            this.id = Storage.getNextItemID();
            return this;
        }

        public GenerativeItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GenerativeItemBuilder price(double price) {
            this.price = price;
            return this;
        }

        public GenerativeItemBuilder group(Group group) {
            this.group = group;
            return this;
        }

        public GenerativeItemBuilder configuration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public GenerativeItemBuilder complexity(Complexity complexity) {
            this.complexity = complexity;
            return this;
        }

        public GenerativeItem build() {
            return new GenerativeItem(this);
        }
    }
}
