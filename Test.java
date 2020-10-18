import java.util.*;

class MyException extends Exception{
    MyException(String s){
        super(s);
    }
}

class Test { 
    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        v.addAll(Arrays.asList(1,2,3,4,5));
        System.out.print(v.get(8));
    }
}