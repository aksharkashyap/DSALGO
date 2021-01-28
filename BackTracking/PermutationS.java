package BackTracking;

class PermutationS{


    public void permute(String str, int l, int r)
    {

        if(l == r)
            System.out.println(str);
        
        else{

            for(int i=l; i<=r;i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }

    }

    public String swap(String str, int l, int r)
    {
        char arr[] = str.toCharArray();
        char temp;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return String.valueOf(arr);
    }

    public static void main(String args[]){
        PermutationS p = new PermutationS();
        String s = "abc";
        p.permute(s,0,s.length()-1);

    }
}
/**
 * : O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation
 */