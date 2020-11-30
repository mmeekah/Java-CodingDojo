import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    public static void main(String[] args) {
        int[] nums = { 23, 234, 2345, -23, 42 };
        // OneTo255();
        // PrintOdds();
        // PrintSum();
        // IterateArray(nums);
        // FindMax(nums);
        // GetAverage(nums);
        // OddArray();
        // GreaterThanY(nums, 0);
        // SquareValues(nums);
        // EliminateNegatives(nums);
        // MinMaxAvg(nums);
        ValueShift(nums);
    }
    public static void OneTo255() {
        for(int i = 1; i <= 255; i++) {
            
        }
    }
    public static void PrintOdds() {
        for(int i = 1; i <= 255; i ++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
    public static void PrintSum() {
        int sum = 0;
        for(int i = 1; i <= 255; i ++){
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public static void IterateArray(int[] arr) {
        for(int val: arr){
            System.out.println(val);
        }
    }
    public static void FindMax(int[] arr) {
        int max = arr[0];
        for(int val: arr){
            if(val > max){
                max = val;
            }
        }
        System.out.println(max);
    }
    public static void GetAverage(int[] arr) {
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        double average = sum / arr.length;
        System.out.println(average);
    }
    public static void OddArray() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i <= 255; i ++) {
            if(i % 2 != 0){
                y.add(i);
            }
        }
        System.out.println(y);
    }
    public static void GreaterThanY(int[] arr, int y) {
        int count = 0;
        for(int val: arr){
            if(val > y){
                count ++;
            }
        }
        System.out.println(count);
    }
    public static void SquareValues(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void EliminateNegatives(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void MinMaxAvg(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int avg = sum / arr.length;
        System.out.println("Min: " + min + " Max: " + max + " Avg: " + avg);
    }
    public static void ValueShift(int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}