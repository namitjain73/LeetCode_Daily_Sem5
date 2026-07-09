// Last updated: 7/9/2026, 5:13:52 PM
class MovieRentingSystem {
    private static class Entry implements Comparable<Entry> {
        int price, shop, movie;
        
        Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
        
        public int compareTo(Entry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            
            return this.movie - other.movie;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry other = (Entry) o;
            return this.price == other.price 
                && this.shop == other.shop 
                && this.movie == other.movie;
        }

        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }
    
    private final Map<Integer, PriorityQueue<Entry>> availableMovies;
    private final TreeSet<Entry> rentedMovies;
    private final Set<Long> rentedSet;
    private final Map<Long, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        availableMovies = new HashMap<>();
        rentedMovies = new TreeSet<>();
        rentedSet = new HashSet<>();
        priceMap = new HashMap<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            long key = ((long) shop << 32) | movie;
            
            priceMap.put(key, price);
            availableMovies
                .computeIfAbsent(movie, k -> new PriorityQueue<>())
                .add(new Entry(price, shop, movie));
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!availableMovies.containsKey(movie)) return result;

        PriorityQueue<Entry> heap = availableMovies.get(movie);
        List<Entry> temp = new ArrayList<>();
        
        while (!heap.isEmpty() && result.size() < 5) {
            Entry entry = heap.poll();
            long key = ((long) entry.shop << 32) | entry.movie;
            
            if (!rentedSet.contains(key)) {
                result.add(entry.shop);
            }
            temp.add(entry);
        }
        
        for (Entry entry : temp) {
            heap.add(entry);
        }
        
        return result;
    }
    
    public void rent(int shop, int movie) {
        long key = ((long) shop << 32) | movie;
        if (!priceMap.containsKey(key)) return;
        
        rentedSet.add(key);
        int price = priceMap.get(key);
        Entry entry = new Entry(price, shop, movie);
        rentedMovies.add(entry);
    }
    
    public void drop(int shop, int movie) {
        long key = ((long) shop << 32) | movie;
        if (!priceMap.containsKey(key)) return;
        
        rentedSet.remove(key);
        int price = priceMap.get(key);
        Entry entry = new Entry(price, shop, movie);
        rentedMovies.remove(entry);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Entry> iterator = rentedMovies.iterator();
        
        while (iterator.hasNext() && result.size() < 5) {
            Entry entry = iterator.next();
            long key = ((long) entry.shop << 32) | entry.movie;
            
            if (rentedSet.contains(key)) {
                result.add(Arrays.asList(entry.shop, entry.movie));
            }
        }
        
        return result;
    }
}