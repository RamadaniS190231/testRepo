import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTester {

    //Soll dann in der set Methode etwas auf der Konsole ausgegeben werden?
    private NumberTest primeTester;
    private NumberTest oddTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName){

    }

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        try {
            File myObj = new File("NumberFile.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            int range = Integer.parseInt(data);

            for(int i = 0; i < range; i++){
                data = myReader.nextLine();
                String[] arr = data.split(" ");
                int number1 = Integer.parseInt(arr[0]);
                int number2 = Integer.parseInt(arr[1]);

                switch (number1){
                    case 1: ;
                    break;

                    case 2: ;
                    break;

                    case 3: ;
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
