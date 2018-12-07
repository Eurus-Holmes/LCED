class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null|| cost==null||gas.length==0||cost.length==0||gas.length!=cost.length)
         return -1;
         
        int sum = 0;  
        int total = 0;  
        int index = 0;  
        for(int i = 0; i < gas.length; i++){  
            sum += gas[i]-cost[i];  
            total += gas[i]-cost[i];  
            if(sum < 0){  
                index=i+1; 
                sum = 0;   
            } 
        }  
        if(total<0)
            return -1;  
        else
            return index;  
    }
}
