import java.util.*;
import java.io.*;
import java.math.*;

class Test{

    static double getSum( List< ? extends Number> numbers){
        double sum = 0.0;

        for(Number num : numbers){
            sum += num.doubleValue();
        }

        return sum;
    }

    static void addCoupleOfValues(List<? super Number> numbers){
        numbers.add(1);
        numbers.add(2.3);
    }

    public static void main(String[] args) {
        System.out.println(getSum(List.of(1,2,3,4,5)));
        System.out.println(getSum(List.of(1.5,2.5,3.5)));
    }
}