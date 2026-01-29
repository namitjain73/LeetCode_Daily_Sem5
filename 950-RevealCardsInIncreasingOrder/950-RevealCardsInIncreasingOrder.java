// Last updated: 1/29/2026, 7:58:59 PM
1class Solution {
2    public int[] deckRevealedIncreasing(int[] deck) {
3        Deque<Integer> q = new ArrayDeque<>();
4        Arrays.sort(deck);
5        int n = deck.length;
6        q.add(deck[n-1]);
7        for(int i = n-2 ; i >= 0 ; i--){
8            q.addFirst(q.removeLast());
9            q.addFirst(deck[i]);
10        }
11        int i = 0;
12        while(!q.isEmpty()){
13            deck[i++] = q.removeFirst();
14        }
15        return deck;
16    }
17}