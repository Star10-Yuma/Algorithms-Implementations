public class DynamicStack extends CustomStack{

    //This stack will never be FULL

    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        //This takes care of array being full
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];

            //copy all previous items in new data
            for (int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }

        //at this point we know that the array is not full so we push it normally
        return super.push(item);
    }
}
