package Java;
import java.util.*;
class ReverseSpecial{
    public static String reverseFunc(String str)
    {
        char arr[] = str.toCharArray();
        ArrayList<Character> alpha = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(Character.isAlphabetic(arr[i]))
                alpha.add(arr[i]);
        }
        Collections.reverse(alpha);
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(Character.isAlphabetic(arr[i])){
                arr[i] = alpha.get(j);
                j++;
            }
        }

        String reversed = String.valueOf(arr);

        return reversed;

    }
    public static void main(String args[])
    {

            String str = "a,ks%ha,r";
            System.out.println(reverseFunc(str));
    }
}