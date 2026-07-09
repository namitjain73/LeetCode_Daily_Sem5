// Last updated: 7/9/2026, 5:23:39 PM
class Solution {
    public String largestNumber(int[] nums) {
        return cheak(nums);
        
    }

    

	public static String cheak(int[] arr) {
		String[] str = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			str[i] = Integer.toString(arr[i]);
		}
		int n = str.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				String first = str[j] + str[j+1];
				String second = str[j+1] + str[j];
				if(second.compareTo(first) > 0) {
					String temp = str[j];
					str[j] = str[j+1];
					str[j+1] = temp;
				}
			}
		}
		if(str[0].equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String val : str) {
			sb.append(val);
		}
		return sb.toString();
	}

}