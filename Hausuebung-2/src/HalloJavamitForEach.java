import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    /*Erstes Beispiel
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Noah ");
        list.add("Schmolz ");
        list.add("Shaban ");
        list.add("Ramani");

        list.forEach((s) -> System.out.print(s));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

    }*/

    //Zweites Beispiel

    public static void main(String[] args) {

        NumberTest isEven = (number) -> {
            if (number%2 == 0){
                return true;
            }else {
                return false;
            }
        };

        NumberTest isPrime = (number) -> {
            boolean flag = false;
            for (int i = 2; i <= number / 2; ++i) {

                if (number % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return true;
            }else{
                    return false;
            }
        };

        NumberTest isPalindrome = (number) -> {
            int r,sum=0,temp;

            temp=number;
            while(number>0){
                r=number%10;  
                sum=(sum*10)+r;
                number=number/10;
            }
            if(temp==sum) {
                return true;
            }else {
                return false;
            }
        };

        NumberTester nt = new NumberTester("NumberFile.txt");
        nt.setOddEvenTester(isEven);
        nt.setPrimeTester(isPrime);
        nt.setPalindromeTester(isPalindrome);

        nt.testFile();

    }
}
