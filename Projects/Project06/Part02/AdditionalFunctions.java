package part02Package;
import java.util.Random;

public class AdditionalFunctions {

    public  Integer[][] createArray(int rowSize ,int columnSize){
        Random randomGenerator = new Random();
        Integer[][] arrayMain = new Integer[rowSize][];
        for (int i = 0; i < arrayMain.length; i++) {
            arrayMain[i] = new Integer[columnSize];
            for (int j = 0; j < arrayMain[i].length; j++) {
                arrayMain[i][j] = (Integer) randomGenerator.nextInt(100) + 1;
            }
        }
        return arrayMain;
    }
    public void printArrayItems(Integer arr[][]){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
