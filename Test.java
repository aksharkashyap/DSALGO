class Test{

    static void solve(String str,int l,int r){
        if(l==r){
            //print string
            System.out.println(str);
        }
        for(int i=l;i<=r;i++){
            str = swap(str, l, i);
            solve(str, l+1, r);
            str = swap(str, l,i);
        }
    }

    static String swap(String str, int a , int b){
        char[]arr = str.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        String str = "abc";
        solve(str,0,str.length()-1);
    }
}