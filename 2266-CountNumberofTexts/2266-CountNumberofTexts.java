// Last updated: 1/28/2026, 11:10:56 PM
1class Solution {
2    public int countTexts(String pressedKeys) {
3        int[] memo=new int[pressedKeys.length()];
4        
5        return dfs(pressedKeys,memo,0);
6    }
7    
8    public int dfs(String pk,int[] memo,int index){
9        if(index==pk.length())  //if end of string is reached that is one permutation
10            return 1;
11        
12        if(memo[index]!=0)      //if countof permutations for that index is already calculated
13            return memo[index];
14        
15        int count=0;
16        for(int i=0;i<4;i++){   //max we need to go four index forward
17            //for only button 7 and 9 we have 4 charcters
18            if(pk.charAt(index)!='7' && pk.charAt(index)!='9' && i==3)  
19                break;
20            
21            if(index+i>=pk.length())    //if end index goes out of bounds
22                break;
23              
24            if(i!=0){  
25                //if adjacent characters are not same
26                if(pk.charAt(index+i)!=pk.charAt(index+i-1))    
27                    break;
28            }
29            
30            count+=dfs(pk,memo,index+i+1);  //recursive call for remaining string
31            count%=1000000007;
32                
33        }
34        
35        memo[index]=count;  //store the calculated value for this index
36        return count;
37    }
38}