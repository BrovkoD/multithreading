package model;

public class SecondDTO implements BaseDTO {

    private double number;

    public SecondDTO() {
    }

    public SecondDTO(double number) {
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
        return "SecondPOJO{" +
                "number=" + number +
                '}';
    }
}
