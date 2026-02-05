// Last updated: 2/5/2026, 11:38:45 PM
1class Solution {
2    class Transaction {
3        String name;
4        int time;
5        int amount;
6        String city;
7        public Transaction(String line) {
8            String[] items = line.split(",");
9            this.name = items[0];
10            this.time = Integer.parseInt(items[1]);
11            this.amount = Integer.parseInt(items[2]);
12            this.city = items[3];
13        }
14    }
15    public List<String> invalidTransactions(String[] transactions) {
16        List<String> res = new ArrayList<>();
17        Map<String, List<Transaction>> map = new HashMap<>(); // <name, Transaction>
18        for (String transaction : transactions) {
19            Transaction t = new Transaction(transaction);
20            map.putIfAbsent(t.name, new ArrayList<>()); 
21            map.get(t.name).add(t);
22        }
23
24        for (String transaction : transactions) {
25            Transaction t = new Transaction(transaction);
26
27            List<Transaction> transactionList = map.get(t.name);
28            if (!isValidTransaction(transactionList, t)) { // compare current transaction with the list
29                res.add(transaction);
30            }
31        }
32        return res;
33    }
34
35    // helper to determine if transaction is invalid
36    public boolean isValidTransaction(List<Transaction> list, Transaction currentT) {
37            if (currentT.amount > 1000) {
38                return false;
39            }
40            for (Transaction t: list) {
41                // Order doesnt matter
42                // if any 2 transaction <= 60 min and diff city, add both
43                if (Math.abs(t.time-currentT.time ) <= 60 && !currentT.city.equals(t.city) ) {
44                    return false;
45                }
46            }
47            return true;
48    }
49
50
51}