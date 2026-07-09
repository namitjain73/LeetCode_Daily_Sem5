// Last updated: 7/9/2026, 5:26:04 PM
class Solution {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int n = 0;
        int max = s.length()-1;
        for(int i = 0 ; i <= max ; i++){
            if(ch[i] == 'I'){
                n += 1;
                if(max != i && ch[i+1] == 'V'){
                    n += 3;
                    i++;
                }
                else if(max != i && ch[i+1] == 'X'){
                    n += 8;
                    i++;
                    
                }
            }
            else if(ch[i] == 'X'){
                    n += 10;
                if(max != i && ch[i+1] == 'L'){
                    n += 30;
                    i++;
                    
                }
                else if(max != i && ch[i+1] == 'C'){
                    n += 80;
                    i++;
                    
                }

            }
            else if(ch[i] == 'C'){
                    n += 100;
                if(max != i && ch[i+1] == 'D'){
                    n += 300;
                    i++;
                    
                }
                else if(max != i && ch[i+1] == 'M'){
                    n += 800;
                    i++;
                    
                }
                
            }
            else if(ch[i] == 'V'){
                n += 5;

            }
            else if(ch[i] == 'L'){
                n += 50;
                
            }
            else if(ch[i] == 'D'){
                n+=500;
                
            }
            else if(ch[i] == 'M'){
                 n += 1000;
                
            }
            
        }
        return n;
        
    }
}