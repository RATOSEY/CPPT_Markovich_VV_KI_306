package KI306.Markovich.Lab6;

public class TruckDriver {

    public static void main(String[] args) {
        // --- ТЕСТ 1: Машина з Коробками ---
        System.out.println(">>>> ЗАПУСК МАШИНИ З КОРОБКАМИ <<<<");
        CargoTruck<Box> boxTruck = new CargoTruck<>();
        
        boxTruck.loadCargo(new Box("Електроніка", 50));
        boxTruck.loadCargo(new Box("Одяг", 20));
        boxTruck.loadCargo(new Box("Меблі", 150));
        boxTruck.loadCargo(new Box("Книги", 10)); // Найлегша
        
        boxTruck.printTruckContents();
        
        Box minBox = boxTruck.findMinCargo();
        System.out.println("Знайдено найлегший вантаж: " + minBox);
        
        System.out.println("\nВивантажуємо меблі (індекс 2)...");
        boxTruck.unloadCargo(2);
        boxTruck.printTruckContents();
        

        // --- ТЕСТ 2: Машина з Палетами ---
        System.out.println("\n\n>>>> ЗАПУСК МАШИНИ З ПАЛЕТАМИ <<<<");
        CargoTruck<Pallet> palletTruck = new CargoTruck<>();
        
        palletTruck.loadCargo(new Pallet("Euro", 100));
        palletTruck.loadCargo(new Pallet("Industrial", 500));
        palletTruck.loadCargo(new Pallet("Plastic", 20)); // Найменша
        
        Pallet minPallet = palletTruck.findMinCargo();
        System.out.println("Палета з найменшою кількістю речей: " + minPallet);
    }
}