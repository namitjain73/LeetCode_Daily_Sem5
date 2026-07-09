// Last updated: 7/9/2026, 5:16:02 PM
class Solution {
    
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        //total courses mask
        int course_mask = (1<<n) - 1;
        
        this.dp = new Integer[course_mask+1] ;
        
        return helper(n, relations, course_mask, k) ;
    }
    
    
    Integer dp[] ;
    
    int helper(int n, int[][] relations, int course_mask, int k) {
        
        //if all courses are visited
        if(course_mask == 0) return 0 ;
        
        if(dp[course_mask]!= null) return dp[course_mask] ;
        
        //calculating indegree
        int indeg[] = new int[n] ;
        for(int rel[] : relations) {
            int u = rel[0]-1 ;
            int v = rel[1]-1 ;
            if(isBitOn(course_mask, u)) indeg[v]++ ;
        }
        
        //mask for total available course to take this semester 
        int avail_course_mask = 0 ;
        for(int i=0 ; i<indeg.length ; i++) {
            if(indeg[i] == 0 && isBitOn(course_mask,i)) 
                avail_course_mask = setKthBit(avail_course_mask, i) ;
        }
        
        //total available course in this semester
        int total_available_course_this_sem = countSetBits(avail_course_mask) ;
        
        if(total_available_course_this_sem <= k) {
            int newMask = (course_mask ^ avail_course_mask) ;
            return dp[course_mask] = 1 + helper(n, relations, newMask, k) ;
        }
        
        //Generating all permutation of avail_course_mask in which K bit is ON.
        int min = n ;
        for(int subs = avail_course_mask ; subs > 0 ; subs = (subs-1) & avail_course_mask) {
            if(countSetBits(subs) == k) {
                int newMask = (course_mask ^ subs) ;
                int temp = 1 + helper(n, relations, newMask, k) ;
                min = Math.min(min,temp) ;
            }
        }
        
        return dp[course_mask] = min ;
    }
    
    boolean isBitOn(int num, int k) {
        return (num&(1<<k)) > 0 ;
    }
    
    int setKthBit(int num, int k) {
        return (num^(1<<k)) ;
    }
    
    int countSetBits(int num) {
        int count = 0 ;
        while(num != 0) {
            num &= (num-1) ;
            count++ ;
        } 
        return count ;
    }
}