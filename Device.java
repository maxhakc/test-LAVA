class Device {
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
    public int getPower() { return power; }
    public void setName(String name) { this.name = name; }
    public void setPower(int power) { this.power = power; }

    public void showInfo() {
        System.out.println("Пристрій: " + name);
    }

    public void showInfo(boolean detailed) {
        showInfo();
        if (detailed) System.out.println("Потужність: " + power + " Вт");
    }
}

