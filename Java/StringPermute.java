package Java;

class Permute{

    public void permute_func(String str, int l, int r){
        if(l==r)
            System.out.println(str);
        else{
            for(int i=l;i<=r;i++){
                str = swap(str,l,i);
                permute_func(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public String swap(String str, int i, int j){
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void main(String args[]){
        String str = "ABC";
        int n = str.length();
        Permute p = new Permute();
        p.permute_func(str,0,n-1);
    }
}