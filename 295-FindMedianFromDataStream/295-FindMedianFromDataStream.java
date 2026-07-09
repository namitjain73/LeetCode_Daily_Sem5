// Last updated: 7/9/2026, 5:22:33 PM
class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> {return b-a;});
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) max.add(num);
        else min.add(num);

        if(max.size() < min.size()) max.add(min.poll());
        else if(max.size() > min.size()+1) min.add(max.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            double median = (max.peek() + min.peek()) / 2.0;
            return median;
        }
        return (double)max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */