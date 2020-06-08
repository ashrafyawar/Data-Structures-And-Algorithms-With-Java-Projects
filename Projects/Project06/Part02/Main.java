package part02Package;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AdditionalFunctions tem = new  AdditionalFunctions();
        MergeSort mSortObj = new MergeSort();
        // [100][10000]

        //sort(int[] items)
        Integer[][] arr1 = tem.createArray(100,10000);
        for (int i = 0; i < arr1.length;i++){ mSortObj.sort(arr1[i]); }
        //tem.printArrayItems(arr1);
        System.out.println("RunTime: ");

        // [5] [1000]

        //sort(int[] items)
        Integer[][] arr2 = tem.createArray(5,10000);
        for (int i = 0; i < arr2.length; i++) { mSortObj.sort(arr2[i]); }
        for (int i = 0; i < arr2.length; i++) { mSortObj.sort(arr2[i]); }
       // tem.printArrayItems(arr2);
        System.out.println("RunTime:");
        //**************************************************************************************************************
    /*
        // 100 [40000]

        //sort(int[] items)
        Integer[][] arr3 = tem.createArray(100,40000);
        for (int i = 0; i < arr3.length;i++){ mSortObj.sort(arr3[i]); }
        tem.printArrayItems(arr3);

        // [5][40000]

        //sort(int[] items)
        Integer[][] arr4 = tem.createArray(5,40000);
        for (int i = 0; i < arr4.length; i++) { mSortObj.sort(arr4[i]); }
        for (int i = 0; i < arr4.length; i++) { mSortObj.sort(arr4[i]); }
        tem.printArrayItems(arr4);
        //**************************************************************************************************************

        // 100 [100000]

        //sort(int[] items)
        Integer[][] arr5 = tem.createArray(100,100000);
        for (int i = 0; i < arr5.length;i++){ mSortObj.sort(arr5[i]); }
        tem.printArrayItems(arr5);

        // [5][100000]

        //sort(int[] items)
        Integer[][] arr6 = tem.createArray(5,100000);
        for (int i = 0; i < arr6.length; i++) { mSortObj.sort(arr6[i]); }
        for (int i = 0; i < arr6.length; i++) { mSortObj.sort(arr6[i]); }
        tem.printArrayItems(arr6);
        //**************************************************************************************************************

        // 100 [150000]

        //sort(int[] items)
        Integer[][] arr7 = tem.createArray(100,150000);
        for (int i = 0; i < arr7.length;i++){ mSortObj.sort(arr7[i]); }
        tem.printArrayItems(arr7);

        // [5][150000]

        //sort(int[] items)
        Integer[][] arr8 = tem.createArray(5,150000);
        for (int i = 0; i < arr8.length; i++) { mSortObj.sort(arr8[i]); }
        for (int i = 0; i < arr8.length; i++) { mSortObj.sort(arr8[i]); }
        tem.printArrayItems(arr8);
        //**************************************************************************************************************

        // 100 [180000]

        //sort(int[] items)
        Integer[][] arr9 = tem.createArray(100,180000);
        for (int i = 0; i < arr9.length;i++){ mSortObj.sort(arr9[i]); }
        tem.printArrayItems(arr9);

        // [5][180000]

        //sort(int[] items)
        Integer[][] arr10 = tem.createArray(5,180000);
        for (int i = 0; i < arr10.length; i++) { mSortObj.sort(arr10[i]); }
        for (int i = 0; i < arr10.length; i++) { mSortObj.sort(arr10[i]); }
        tem.printArrayItems(arr10);*/
        //**************************************************************************************************************
    }
}