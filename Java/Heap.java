package Java;
//mx heap
//insert
//delete
//heapify
class Heap{

    int Heap[] = new int[10];
    int ptr=0;
    
    Heap(){ Heap[0] = Integer.MAX_VALUE; } 
    int parent(int pos){ return (pos)/2; }
    int left_child(int pos){ return 2*pos; }
    int right_child(int pos){ return 2*pos+1; }

    void heapify(int pos,int n){
        int largest = pos;
        int l = left_child(pos);
        int r = right_child(pos);

        if(l<=n && Heap[l] > Heap[pos]) largest = l;
        if(r<=n && Heap[r] > Heap[pos]) largest = r;
        
        if(largest !=pos){
            swap(pos, largest);
            heapify(largest, n);
        }
    }

    void delete(){
        Heap[0] = Heap[ptr--];
        heapify(0,ptr);
    }

    void swap(int current, int parent){
        int temp;
        temp = Heap[current];
        Heap[current] = Heap[parent];
        Heap[parent] = temp; 
    }

    void insert(int data)
    {   Heap[++ptr]=data;
        int current = ptr;
        while(Heap[current] > Heap[parent(current)])
            {
                swap(current, parent(current));
                current = parent(current);
            }

    }

    int peek(){
        return Heap[0];
    }

   void print(){
        for(int i=1;i<=ptr;i++){
            System.out.print(Heap[i]+" ");
        }
    }

  /*  void print()
    {
        for(int i=1; i<=ptr/2;i++)
        {
            System.out.print("parent "+Heap[(i/2)] + " left: "+ Heap[2*i] + " right: "+ Heap[2*i+1]+"\n");
        }
    }
    */

    public static void main(String args[])
    {
     
        Heap h = new Heap();
        h.insert(10);
        h.insert(11);
        h.insert(9);
        h.insert(45);
        h.insert(20);
        h.print();
        h.delete();
        System.out.println();
        System.out.println("peek " + h.peek());
        System.out.println();
        h.print();
    }

}