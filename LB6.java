class Processor {
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

class Laptop extends Device {
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

public class LB6 {
    public static void main(String[] args) {
        Device defaultDevice = new Device();
        Device device = new Device("Настільний комп'ютер", 450);
        Laptop defaultLaptop = new Laptop();
        Laptop laptop = new Laptop("Ноутбук Lenovo", 90, new Processor("Ryzen 7", 8));

        defaultDevice.showInfo();
        device.showInfo(true);
        defaultLaptop.showInfo();
        laptop.showInfo();
        laptop.showInfo(true);
    }
}