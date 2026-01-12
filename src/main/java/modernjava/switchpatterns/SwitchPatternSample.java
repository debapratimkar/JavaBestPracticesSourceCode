package modernjava.switchpatterns;

public class SwitchPatternSample {

    public static void main(String[] args) {
        Vehicle car = new Car(1200, 5, true);

        System.out.println("-- OLD APPROACH --");
        printLicenseOldApproach(car);

        System.out.println("\n-- NEW APPROACH --");
        printLicenseNewApproach(car);
        printDescriptionNewApproach(car);
        printRoadTripTestNewApproach(car);
    }

    public static void printLicenseOldApproach(Vehicle vehicle) {
        String licenseRequirement = "";

        switch (vehicle.getWeightCategory()) {
            case LIGHT:
                licenseRequirement = "You need a light vehicle license.";
                break;
            case MEDIUM:
                licenseRequirement = "You need a regular license.";
                break;
            case HEAVY:
                licenseRequirement = "You need a commercial license.";
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle weight category");
        }

        System.out.println(licenseRequirement);
    }

    public static void printLicenseNewApproach(Vehicle vehicle) {
        String licenseRequirement = switch (vehicle.getWeightCategory()) {
            case LIGHT -> "You need a motorcycle license.";
            case MEDIUM -> "You need a regular car license.";
            case HEAVY -> "You need a commercial driving license.";
            default -> throw new IllegalArgumentException("Unknown vehicle weight category");
        };
        System.out.println(licenseRequirement);
    }
    public static void printDescriptionNewApproach(Vehicle vehicle) {
        String result = switch (vehicle) {
            case Motorcycle m -> "It's a motorcycle with a light weight.";
            case Bicycle b -> "It's a bicycle, light and eco-friendly.";
            case Car c -> "It's a car, perfect for family trips.";
            case Truck t -> "It's a truck, built for heavy loads.";
            default -> "Unknown vehicle type";
        };
        System.out.println(result);
    }
    public static void printRoadTripTestNewApproach(Vehicle vehicle) {
        // 2 approaches presented: Motorcycle(double weight, int engineSize) vs Truck t, choose one in real code
        String result = switch (vehicle) {
            case Car c when !c.isElectric() && c.numDoors() >= 4 -> "This car is perfect for a road trip!";
            case Car c when c.isElectric() -> "This car is electric, not ideal for a road trip.";
            case Motorcycle(double weight, int engineSize) when engineSize > 1000 -> "This motorcycle is ready for a long trip!";
            case Motorcycle(double weight, int engineSize) -> "This motorcycle might not be ideal for long distances.";
            case Truck t when t.cargoCapacity() > 5000 -> "This truck is perfect for carrying heavy loads!";
            case Truck t when t.cargoCapacity() <= 5000 -> "This truck might not have enough capacity for a big haul.";
            case Bicycle b when b.isElectric() -> "This electric bike is great for short trips.";
            case Bicycle b -> "This bike is perfect for short and eco-friendly trips!";
            default -> "This vehicle is not suitable for a road trip.";
        };

        System.out.println(result);
    }

}
