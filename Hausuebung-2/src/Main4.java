import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit Program");

        int input = sc.nextInt();

        switch (input){
            case 1: ;
            break;

            case 2: ;
                break;

            case 3: ;
                break;

            case 4:
                sc.close();
                System.out.println("Programm exited");
                break;
        }
    }
}
