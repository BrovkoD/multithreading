package hw2.model;

public class FirstDTO implements BaseDTO {

    private double number;

    public FirstDTO() {
    }

    public FirstDTO(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FirstPOJO{" +
                "number=" + number +
                '}';
    }
}
