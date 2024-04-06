
public class Solution {
    public int[] powerArray(int[] nums) {
        if (nums == null) {
          return null;
        }
         
         int firstPoint = 0;
         var secondPoint = nums.length - 1;
         var result = new int[nums.length];
         var resultPoint = secondPoint;
         
         while (secondPoint >= firstPoint) {
          var firstNum = nums[firstPoint];
           var secondNum = nums[secondPoint];
          if (firstNum * firstNum >= secondNum * secondNum) {
            result[resultPoint--] = firstNum * firstNum;
             firstPoint++;
           } else {
            result[resultPoint--] = secondNum * secondNum;
             secondPoint--;
           }
        }
         
        return result;
    }
}
