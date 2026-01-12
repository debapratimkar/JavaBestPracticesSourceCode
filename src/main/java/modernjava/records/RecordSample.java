package modernjava.records;

public class RecordSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        StandardBook book = new StandardBook("Java Best Practices", "Adrian Wiech");
        System.out.println(book);
    }

    private static void showGoodPractice() {
        RecordBook book = new RecordBook("Java Best Practices", "Adrian Wiech");
        System.out.println(book);
    }
}
