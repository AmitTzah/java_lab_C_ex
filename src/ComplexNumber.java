public class ComplexNumber {

    //Data members

    private double real;
    private double  imaginary;
    public static ComplexNumber epsilon = new ComplexNumber(0.001, 0);

    //Constructor

    public ComplexNumber(double realPart, double imaginaryPart){
        real = realPart;
        imaginary = imaginaryPart;

    }

    //Methods

    public ComplexNumber plus(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber minus(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber times(ComplexNumber other) {
        double new_radius = this.getRadius() * other.getRadius();
        double new_argument = this.getArgument() + other.getArgument();
        return fromPolarCoordinates(new_radius, new_argument);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double new_radius = this.getRadius() / other.getRadius();
        double new_argument = this.getArgument() - other.getArgument();
        return fromPolarCoordinates(new_radius, new_argument);
    }

    private static ComplexNumber fromPolarCoordinates(double radius, double argument) {
        return new ComplexNumber(radius*Math.cos(argument), radius*Math.sin(argument));
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public double getRadius() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    public double getArgument() {
        return Math.atan2(imaginary, real);
    }

    public boolean almostEquals(ComplexNumber other) {

        return this.minus(other).getRadius() < epsilon.getRadius();

    }


}


