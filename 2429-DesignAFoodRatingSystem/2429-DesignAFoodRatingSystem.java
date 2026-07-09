// Last updated: 7/9/2026, 5:10:15 PM
class FoodRatings {
    class Pair{
        int rating;
        String food;
        Pair(int rating , String food){
            this.rating = rating;
            this.food = food;
        }
    }
    HashMap<String,String> map1 = new HashMap<>();;
    Map<String,PriorityQueue<Pair>> map2 = new HashMap<>();
    Map<String ,Integer> map3 = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0 ; i < foods.length ; i++){
            map1.put(foods[i],cuisines[i]);
            map3.put(foods[i],ratings[i]);
            map2.putIfAbsent(cuisines[i] , new PriorityQueue<>((a,b)->{
                if(a.rating == b.rating) return a.food.compareTo(b.food);
                return b.rating - a.rating;
            }));

            map2.get(cuisines[i]).add(new Pair(ratings[i],foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        map3.put(food,newRating);
        map2.get(map1.get(food)).add(new Pair(newRating,food));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = map2.get(cuisine);
        while(true){
            Pair top = pq.peek();
            if(top.rating == map3.get(top.food)) return top.food;
            pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */