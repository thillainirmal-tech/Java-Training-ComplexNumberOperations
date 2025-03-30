public class ComplexNumber {

    private double real;
    private double imaginary;

    // == Constructor ==
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // == Getters ==
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // == Addition Methods ==
    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber other) {
        if (other != null) {
            add(other.real, other.imaginary);
        }
    }

    // == Subtraction Methods ==
    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber other) {
        if (other != null) {
            subtract(other.real, other.imaginary);
        }
    }

    // == Multiplication ==
    public void multiply(double real, double imaginary) {
        double newReal = (this.real * real) - (this.imaginary * imaginary);
        double newImaginary = (this.real * imaginary) + (this.imaginary * real);
        this.real = newReal;
        this.imaginary = newImaginary;
    }

    public void multiply(ComplexNumber other) {
        if (other != null) {
            multiply(other.real, other.imaginary);
        }
    }

    // == Division ==
    public void divide(double real, double imaginary) {
        double denominator = real * real + imaginary * imaginary;
        if (denominator == 0) {
            System.out.println("Cannot divide by zero.");
            return;
        }

        double newReal = (this.real * real + this.imaginary * imaginary) / denominator;
        double newImaginary = (this.imaginary * real - this.real * imaginary) / denominator;

        this.real = newReal;
        this.imaginary = newImaginary;
    }

    public void divide(ComplexNumber other) {
        if (other != null) {
            divide(other.real, other.imaginary);
        }
    }

    // == Equals and HashCode ==
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ComplexNumber other = (ComplexNumber) obj;
        return Double.compare(other.real, real) == 0 &&
                Double.compare(other.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(real, imaginary);
    }

    // == ToString Method ==
    @Override
    public String toString() {
        return String.format("(%.2f %s %.2fi)", real, (imaginary >= 0 ? "+" : "-"), Math.abs(imaginary));
    }

    // == Main Method for Testing ==
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(4.5, 3.2);
        ComplexNumber c2 = new ComplexNumber(2.1, -1.5);

        System.out.println("Initial Numbers:");
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);

        c1.add(c2);
        System.out.println("\nAfter Addition (c1 + c2):");
        System.out.println("c1: " + c1);

        c1.subtract(c2);
        System.out.println("\nAfter Subtraction (c1 - c2):");
        System.out.println("c1: " + c1);

        c1.multiply(c2);
        System.out.println("\nAfter Multiplication (c1 * c2):");
        System.out.println("c1: " + c1);

        c1.divide(c2);
        System.out.println("\nAfter Division (c1 / c2):");
        System.out.println("c1: " + c1);

        System.out.println("\nEquality Check:");
        System.out.println("c1 equals c2: " + c1.equals(c2));

        System.out.println("\nHash Codes:");
        System.out.println("c1 hashCode: " + c1.hashCode());
        System.out.println("c2 hashCode: " + c2.hashCode());
    }
}
