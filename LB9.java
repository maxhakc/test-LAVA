import java.util.Scanner;

public class LB9 {
    static class DeviceArray {
        private Device[] devices;

        public DeviceArray(Device[] devices) {
            this.devices = devices;
        }

        public void show() {
            for (int i = 0; i < devices.length; i++) {
                System.out.println((i + 1) + ". " + devices[i].getName()
                    + " — " + devices[i].getPower() + " Вт");
            }
        }

        public void update(int index, String name, int power) {
            if (index >= 0 && index < devices.length) {
                devices[index].setName(name);
                devices[index].setPower(power);
                System.out.println("Пристрій змінено.");
            } else {
                System.out.println("Немає пристрою з таким номером.");
            }
        }

        public void filter(int power) {
            for (Device device : devices) {
                if (device.getPower() > power) device.showInfo(true);
            }
        }

        public void sort(boolean ascending) {
            for (int i = 0; i < devices.length - 1; i++) {
                for (int j = i + 1; j < devices.length; j++) {
                    if ((ascending && devices[i].getPower() > devices[j].getPower())
                            || (!ascending && devices[i].getPower() < devices[j].getPower())) {
                        Device temp = devices[i];
                        devices[i] = devices[j];
                        devices[j] = temp;
                    }
                }
            }
        }

        public void sortName(boolean ascending) {
            for (int i = 0; i < devices.length - 1; i++) {
                for (int j = i + 1; j < devices.length; j++) {
                    int result = devices[i].getName().compareToIgnoreCase(devices[j].getName());
                    if ((ascending && result > 0) || (!ascending && result < 0)) {
                        Device temp = devices[i];
                        devices[i] = devices[j];
                        devices[j] = temp;
                    }
                }
            }
        }

        public void filterName(String text) {
            for (Device device : devices) {
                if (device.getName().toLowerCase().contains(text.toLowerCase())) {
                    device.showInfo(true);
                }
            }
        }

        public void showExtremes() {
            int min = devices[0].getPower();
            int max = min;
            for (Device device : devices) {
                if (device.getPower() < min) min = device.getPower();
                if (device.getPower() > max) max = device.getPower();
            }
            for (Device device : devices) {
                if (device.getPower() == min)
                    System.out.println("Найменша потужність " + min + " Вт: " + device.getName());
                if (device.getPower() == max)
                    System.out.println("Найбільша потужність " + max + " Вт: " + device.getName());
            }
        }

    }

    public static void main(String[] args) {
        DeviceArray array = new DeviceArray(new Device[] {
            new Device("Ноутбук 1", 65),
            new Device("Комп'ютер 1", 450),
            new Device("Ноутбук 2", 90),
            new Device("Комп'ютер 2", 500),
            new Device("Міні-ПК 1", 35),
            new Device("Комп'ютер 3", 350),
            new Device("Ноутбук 3", 120),
            new Device("Сервер 1", 700),
            new Device("Міні-ПК 2", 45),
            new Device("Комп'ютер 4", 400)
        });

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1 — Показати масив\n2 — Змінити пристрій"
                    + "\n3 — Відбір за потужністю\n4 — Сортувати за зростанням"
                    + "\n5 — Сортувати за спаданням\n6 — Назва за зростанням\n7 — Назва за спаданням"
                    + "\n8 — Пошук за назвою\n9 — Найменша і найбільша потужність\n0 — Вихід");
                System.out.print("Вибір: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0 -> { return; }
                    case 1 -> array.show();
                    case 2 -> {
                        System.out.print("Номер пристрою: ");
                        int index = scanner.nextInt() - 1;
                        scanner.nextLine();
                        System.out.print("Нова назва: ");
                        String name = scanner.nextLine();
                        System.out.print("Нова потужність: ");
                        int power = scanner.nextInt();
                        array.update(index, name, power);
                    }
                    case 3 -> {
                        System.out.print("Потужність більша за: ");
                        array.filter(scanner.nextInt());
                    }
                    case 4 -> { array.sort(true); array.show(); }
                    case 5 -> { array.sort(false); array.show(); }
                    case 6 -> { array.sortName(true); array.show(); }
                    case 7 -> { array.sortName(false); array.show(); }
                    case 8 -> {
                        System.out.print("Частина назви: ");
                        array.filterName(scanner.nextLine());
                    }
                    case 9 -> array.showExtremes();
                }
            }
        }
    }
}
