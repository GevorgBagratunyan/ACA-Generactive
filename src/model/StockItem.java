package model;


import storage.Storage;

public class StockItem extends Item {

    public StockItem(StockItemBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.group, builder.configuration);
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        double price = this.getBasePrice();
        double resolutionCoefficient = configuration.getResolution().getResolutionCoefficient();
        return price * resolutionCoefficient;
    }

    public static class StockItemBuilder {
        private int id;
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;

        public StockItemBuilder id() {
            this.id = Storage.getNextItemID();
            return this;
        }

        public StockItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StockItemBuilder price(double price) {
            this.price = price;
            return this;
        }

        public StockItemBuilder group(Group group) {
            this.group = group;
            return this;
        }

        public StockItemBuilder configuration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public StockItem build() {
            return new StockItem(this);
        }
    }
}
