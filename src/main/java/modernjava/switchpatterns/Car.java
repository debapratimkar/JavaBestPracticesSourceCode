package modernjava.switchpatterns;

record Car(double weight, int numDoors, boolean isElectric) implements Vehicle {
    @Override
    public Weight getWeightCategory() {
        return Weight.MEDIUM;  // Cars are typically medium-weight vehicles
    }
}
