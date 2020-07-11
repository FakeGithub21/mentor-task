import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(ExpressionParser.parse(sc.nextLine()).calc());
        }
        //Основное в тестах
    }
}
