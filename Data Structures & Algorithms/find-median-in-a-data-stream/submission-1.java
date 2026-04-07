class MedianFinder {

    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList(); 
    }
    
    public void addNum(int num) {
        list.add(num);
    
    }
    
    public double findMedian() {
        int size = list.size(); 
        Collections.sort(list);

        double res;
        if(size % 2 == 0){
            res = (double)(list.get((size/2) - 1) + list.get(size/2)) / 2;
        }else {
            res = (double) list.get(size/2);
        }

        return res; 
    }
}


// 1 3 2