package problemfour;

public record Triangle(double base, double height) {
    public double computeArea(){
        return (base * height) /2;
    }
}
