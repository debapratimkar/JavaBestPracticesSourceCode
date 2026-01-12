package modernjava.switchpatterns;

record Bicycle(double weight, boolean isElectric) implements Vehicle {
    @Override
    public Weight getWeightCategory() {
        return Weight.LIGHT;  // Bicycles are light vehicles
    }
}
