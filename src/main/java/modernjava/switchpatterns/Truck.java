package modernjava.switchpatterns;

record Truck(double weight, int cargoCapacity) implements Vehicle {
    @Override
    public Weight getWeightCategory() {
        return Weight.HEAVY;  // Trucks are heavy vehicles
    }
}
