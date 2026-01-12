package modernjava.switchpatterns;

record Motorcycle(double weight, int engineSize) implements Vehicle {
    @Override
    public Weight getWeightCategory() {
        return Weight.LIGHT;  // Motorcycles are generally light vehicles
    }
}
