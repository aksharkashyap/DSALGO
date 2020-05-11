package Java;

class Heapp{

    int Heap[] = new int[10];
    int ptr;
    
    Heapp(){
        Heap[0] = Integer.MAX_VALUE;
        ptr=0;
    }

    int parent(int pos){
        return pos/2;
    }

    int left_child(int pos){
        return 2*pos;
    }

    int right_child(int pos){
        return 2*pos+1;
    }

    public void swap(int current, int parent){
        int temp = Heap[current];
        Heap[current] = Heap[parent];
        Heap[parent] = temp;
    }
    //max heap
    public void insert(int data){
        Heap[++ptr]= data;
        int current = ptr;

        while(Heap[current] > Heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    void print(){
        for(int i=1;i<=ptr;i++){
            System.out.print(Heap[i]+" ");
        }
    }

    public static void main(String args[]){
        Heapp h = new Heapp();
        h.insert(10);
        h.insert(5);
        h.insert(3);
        h.insert(2);
        h.insert(4);
        h.insert(15);
        h.print();
    }
}