package Java;

class ReverseStringE{

    static String t(String s)
    {
        String str = s.trim(); //case 2
        String arr[] = str.split("\\s+"); //case 3
        String newstr="";
        for(int i=arr.length-1;i>=0;i--)
        {     
                newstr = newstr + arr[i]+" "; 
    }
    return newstr.trim();
    }

   public static void main(String agrs[]){ 
       String s=  t("  akshar is   king");
       System.out.println(s);
    }
}