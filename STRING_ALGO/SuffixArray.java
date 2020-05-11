package STRING_ALGO;

// O(n^3logn)

// it can be reduced to o(nlogn)

class STRING_ALGO{

    static class Suffix{
        int index;
        String str;
        Suffix(int index, String str)
        {
            this.index = index;
            this.str = str;
        }
    }

    private static void sortLexo(Suffix []arrS,int size){
        // sort according to lexo and sustain the indexes as well
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(arrS[i].str.compareTo(arrS[j].str)>0)  // if(<0) then a preceeds b,, so no need to swap 
                    {
                        String temp; int tempIndex;
                        temp = arrS[i].str; 
                        tempIndex = arrS[i].index;
                        arrS[i].str = arrS[j].str; 
                        arrS[i].index = arrS[j].index;
                        arrS[j].str = temp; arrS[j].
                        index = tempIndex;
                    }
            }
        }
    }

    private static void printSuffx(Suffix arrS[],int size){
        for(int i=0;i<size;i++){
            System.out.print(arrS[i].index + " "+arrS[i].str+" ");
            System.out.println("");
        }
    }

    private static void suffix_array(String str,int size){
     Suffix []arrS  = new Suffix[size];
     // add the suffixes to our class Suffix objext
     for(int i=0;i<size;i++){
        arrS[i] = new Suffix(i,str.substring(i,size));
     }
     sortLexo(arrS, size);
     printSuffx(arrS, size);
    }
    //Suffix array for banana -> [5,3,1,0,4,2]

    public static void main(String args[]){
        String str = "ababbab";
        suffix_array(str,str.length());
    }
}  
