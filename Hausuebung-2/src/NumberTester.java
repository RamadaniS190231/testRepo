import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTester {
    private String filename;

    private NumberTest primeTester;
    private NumberTest oddTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName) {
        this.filename = fileName;

    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try {
            File myObj = new File("C:\\Schule\\Shuajb-HTL-3\\POS\\testRepo\\Hausuebung-2\\src\\NumberFile.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            int range = Integer.parseInt(data);

            for (int i = 0; i < range; i++) {
                data = myReader.nextLine();
                String[] arr = data.split(" ");
                int number1 = Integer.parseInt(arr[0]);
                int number2 = Integer.parseInt(arr[1]);
                boolean result = false;
                switch (number1) {
                    case 1:
                        result = oddTester.testNumber(number2);
                        if (result != true){
                            System.out.println("NOT EVEN");
                        }else {
                            System.out.println("EVEN");
                        }
                        break;

                    case 2:
                        result = primeTester.testNumber(number2);
                        if (result != true){
                            System.out.println("NOT PRIME");
                        }else {
                            System.out.println("PRIME");
                        };
                        break;

                    case 3:
                        result = palindromeTester.testNumber(number2);
                        if (result != true){
                            System.out.println("NOT PALINDROME");
                        }else {
                            System.out.println("PALINDROME");
                        };
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
