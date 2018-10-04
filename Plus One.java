//  Thought1
/*
class Solution {
    public int[] plusOne(int[] digits) {
        int length;
            length = digits.length;
            for(int i = length-1; i>=0; i--){
                if(digits[i]<9){
                    digits[i]++;
                    break;
                }else{
                    digits[i]=0;
                }
            }
            
            int[] newdigits;
            if(digits[0]==0){
                newdigits = new int[digits.length+1];
                newdigits[0]=1;
                for(int i=1;i<newdigits.length;i++){
                    newdigits[i]=digits[i-1];
                }
            }else{
                newdigits = new int[digits.length];
                for(int i=0;i<digits.length;i++){
                    newdigits[i]=digits[i];
                }
            }
             return newdigits;
    }
}
*/

//    Thought2
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
                digits[i] =1+digits[i];
                
                if(digits[i]==10)
                    digits[i]=0;
                else
                    return digits;
            }

            //don't forget over flow case
            int[] newdigit = new int[digits.length+1];
            newdigit[0]=1;
            for(int i=1;i<newdigit.length;i++){
                newdigit[i] = digits[i-1];
            }
            return newdigit;
    }
}
