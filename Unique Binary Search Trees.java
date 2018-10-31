class Solution {
    public int numTrees(int n) {
        if(n == 0||n == 1)
            return 1;
        
        int[] C = new int[n+1];
        C[0] = 1;
     //递推式是Ct+1 += Ci*Ct-i(0<= i <= t)
     //令num = t+1
     //则 t = num-1;
     //因此递推式化为：
     //Cnum += Ci*Cnum-1-i(0<=i<=num-1, 1<=num<=n)
     //C0 = 1 

    for(int num=1;num<=n;num++){  
        for(int i=0;i<=num-1;i++){  
            C[num] += C[i]*C[(num-1)-i];  
        }  
    }
        return C[n];
    }
}
