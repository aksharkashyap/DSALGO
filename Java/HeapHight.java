package Java;

//height of a complete binary tree or heap
class HeightHeap{

    public static int height(int n)
    {

        return (int) Math.ceil(Math.log(n+1)/Math.log(2))-1;
    }

    public static void main(String args[]){

            System.out.println(height(6));
    }
}