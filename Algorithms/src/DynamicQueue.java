public class DynamicQueue extends CircularQueue{

    //Now the queue won't get full

    public DynamicQueue(){
        super();
    }

    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) {
        //This takes care of array being full
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];

            //copy all previous items in new data
            for (int i = 0; i < data.length; i++){
                temp[i] = data[(frontpointer + i) % data.length];
            }
            frontpointer = 0;
            endpointer = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
