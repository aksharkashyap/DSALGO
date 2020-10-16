import java.io.*;

class MyException extends Exception{

    MyException(String s){
        super(s);
    }
}

class Test { 
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
         try{
            throw new MyException("Handled");

         }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
         finally{

         }
    }
}