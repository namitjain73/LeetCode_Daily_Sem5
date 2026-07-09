// Last updated: 7/9/2026, 5:18:41 PM
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        int n = deck.length;
        q.add(deck[n-1]);
        for(int i = n-2 ; i >= 0 ; i--){
            q.addFirst(q.removeLast());
            q.addFirst(deck[i]);
        }
        int i = 0;
        while(!q.isEmpty()){
            deck[i++] = q.removeFirst();
        }
        return deck;
    }
}