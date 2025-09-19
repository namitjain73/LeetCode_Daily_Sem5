// Last updated: 9/19/2025, 4:05:32 PM
class Spreadsheet {
int[][] arr;
    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char ch = cell.charAt(0);
        int n = Integer.parseInt(cell.substring(1));
        arr[n-1][ch-'A'] = value;
    }
    
    public void resetCell(String cell) {
        char ch = cell.charAt(0);
        int n = Integer.parseInt(cell.substring(1));
        arr[n-1][ch-'A'] = 0;
    }
    
    public int getValue(String formula) {
        StringBuilder s1 = new StringBuilder();
        boolean s1b = true;
        StringBuilder s2 = new StringBuilder();;
        boolean s2b = true;
        int i = 0;
        while(i < formula.length()){
            if(formula.charAt(i) == '+')break;
            i++;
        }
        s1.append(formula.substring(1,i));
        s2.append(formula.substring(i+1));
        if(!(s1.charAt(0)-'0' >= 0 && s1.charAt(0)-'0' <= 9)) s1b = false;
        if(!(s2.charAt(0)-'0' >= 0 && s2.charAt(0)-'0' <= 9)) s2b = false;
        int sum = 0;

        if(s1b) sum += Integer.parseInt(s1.toString());
        else{
            char ch = s1.charAt(0);
            int n = Integer.parseInt(s1.substring(1));
            sum += arr[n-1][ch-'A'];
        }
        if(s2b) sum += Integer.parseInt(s2.toString());
        else{
            char ch = s2.charAt(0);
            int n = Integer.parseInt(s2.substring(1));
            sum += arr[n-1][ch-'A'];
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */