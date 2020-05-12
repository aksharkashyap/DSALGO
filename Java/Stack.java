package Java;

class Stackk
{   int SIZE = 5;
    int arr[] = new int[SIZE]; //0 to 4
    int top;
    Stackk()
    {
        top = -1;
    }
     void push(int x)
    {   
        top++;
        if(top>= arr.length){
            System.out.println("stack overflow");
            top--;}
        else
            arr[top]=x;

    }
     int pop()
    { if(top<0){
        System.out.print("stack underflow");
        return 0;
        }
      return arr[top--];
    }

    void print_stack()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[])
    {
        Stackk stack = new Stackk();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        //System.out.println(stack.pop());
        stack.print_stack();

    }
}