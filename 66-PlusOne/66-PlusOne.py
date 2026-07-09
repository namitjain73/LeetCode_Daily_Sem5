# Last updated: 7/9/2026, 5:25:08 PM
class Solution(object):
    def plusOne(self, List):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        s=''
        L=[]
        for i in List:
            s+=str(i)
        s=int(s)+1
        s=str(s)
        for i in s:
            L.append(int(i))
        return L