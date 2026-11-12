public class LB7 {
    static abstract class Device {
        private String name;
        private int power;

        public Device() {
            this("Обчислювальний пристрій", 100);
        }

        public Device(String name, int power) {
            this.name = name;
            this.power = power;
        }

        public String getName() { return name; }

        public abstract void showInfo();

        public void showInfo(boolean detailed) {
            showInfo();
            if (detailed) System.out.println("Потужність: " + power + " Вт");
        }
    }

    static class Processor {
        private String model;
        private int cores;

        public Processor() {
            this("Core i5", 6);
        }

        public Processor(String model, int cores) {
            this.model = model;
            this.cores = cores;
        }

        public void showInfo() {
            System.out.println("Процесор: " + model + ", ядер: " + cores);
        }
    }

    static class Laptop extends Device {
        private Processor processor;

        public Laptop() {
            this("Ноутбук", 65, new Processor());
        }

        public Laptop(String name, int power, Processor processor) {
            super(name, power);
            this.processor = processor;
        }

        @Override
        public void showInfo() {
            System.out.println("Ноутбук: " + getName());
            processor.showInfo();
        }
    }

    static class Desktop extends Device {
        private Processor processor;

        public Desktop(String name, int power, Processor processor) {
            super(name, power);
            this.processor = processor;
        }

        @Override
        public void showInfo() {
            System.out.println("Настільний комп'ютер: " + getName());
            processor.showInfo();
        }
    }

    public static void main(String[] args) {
        Device laptop = new Laptop();
        Device desktop = new Desktop("Lenovo", 500, new Processor("Ryzen 7", 8));

        laptop.showInfo(true);
        desktop.showInfo(true);
    }
}