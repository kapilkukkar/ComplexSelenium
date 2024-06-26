package HASHMAP;

class Solution {
    public int pivotInteger(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            int leftsum=0;
            int rightsum=0;

            for(int j =1;j<=i;j++)
            {
                leftsum=leftsum+j;
            }
            for(int k=i;k<=n;k++)
            {
                rightsum= rightsum+k;
            }
            if(leftsum==rightsum)
            {
                return i;
            }
        }
        return -1;
        
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.pivotInteger(25);
        System.out.println("Pivot integer: " + result);
    }
}


