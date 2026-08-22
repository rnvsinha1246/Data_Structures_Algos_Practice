class SnapshotArray {
    int snap_id;
    List<List<int[]>> history;
    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for(int i = 0; i < length; i++){
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{0,0});
            history.add(list);
        }
        snap_id = 0;
    }
    
    public void set(int index, int val) {
        List<int[]> list = history.get(index);
        if(list.get(list.size()-1)[0]==snap_id){
            list.get(list.size()-1)[1] = val;
        }else{
            list.add(new int[]{snap_id, val});
        }
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = history.get(index);
        int low = 0;
        int high = list.size()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(list.get(mid)[0] <= snap_id){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return list.get(high)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */