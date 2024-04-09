package dmitryvnn;

public class Program {

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        System.out.println(result);
    }
}
