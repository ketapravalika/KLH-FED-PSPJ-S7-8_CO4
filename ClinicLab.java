
import java.util.Scanner;

interface Test {
    void showResult();
}

class Patient {
    private String name;
    private int age;

    static String clinicName = "Java Clinic";
    static final String DEPARTMENT = "Laboratory";

    Patient() {
        this("Unknown", 0);
    }

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name
                + "\nAge: " + age;
    }
}

class LabTest extends Patient implements Test {
    private String testName;
    private String result;

    LabTest(String name, int age,
            String testName, String result) {
        super(name, age);
        this.testName = testName;
        this.result = result;
    }

    @Override
    public void showResult() {
        System.out.println("Test Name: " + testName);
        System.out.println("Test Result: " + result);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDepartment: " + DEPARTMENT
                + "\nClinic: " + clinicName;
    }
}

public class ClinicLab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();

            System.out.print("Enter patient age: ");
            int age = Integer.parseInt(sc.nextLine());

            if (age <= 0) {
                throw new IllegalArgumentException(
                        "Age must be positive.");
            }

            System.out.print("Enter lab test name: ");
            String testName = sc.nextLine();

            System.out.print("Enter test result: ");
            String result = sc.nextLine();

            LabTest test = new LabTest(
                    name, age, testName, result);

            System.out.println("\n--- CLINIC LAB REPORT ---");
            System.out.println(test);

            Test t = test;
            t.showResult();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid age.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Lab process completed.");
            sc.close();
        }
    }
}
