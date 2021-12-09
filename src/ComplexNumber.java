public class ComplexNumber {

    //Data members

    double real;
    double imaginary;
    static final ComplexNumber epsilon = new ComplexNumber(0.001, 0);

    //Constructor

    ComplexNumber(double realPart, double imaginaryPart){
        real = realPart;
        imaginary = imaginaryPart;

    }

    //Methods

    ComplexNumber plus(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    ComplexNumber minus(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    ComplexNumber times(ComplexNumber other) {
        double new_radius = this.getRadius() * other.getRadius();
        double new_argument = this.getArgument() + other.getArgument();
        return fromPolarCoordinates(new_radius, new_argument);
    }

    ComplexNumber divide(ComplexNumber other) {
        double new_radius = this.getRadius() / other.getRadius();
        double new_argument = this.getArgument() - other.getArgument();
        return fromPolarCoordinates(new_radius, new_argument);
    }

    static ComplexNumber fromPolarCoordinates(double radius, double argument) {
        return new ComplexNumber(radius*Math.cos(argument), radius*Math.sin(argument));
    }

    double getRealPart() {
        return real;
    }

    double getImaginaryPart() {
        return imaginary;
    }

    double getRadius() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    double getArgument() {
        return Math.atan2(imaginary, real);
    }

    boolean almostEquals(ComplexNumber other) {

        return this.minus(other).getRadius() < epsilon.getRadius();

    }


}


