class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return 0;
        }
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        
        int i=0,j=0;
        
        while(i<version1Arr.length || j<version2Arr.length){
            int ver1 = i<version1Arr.length ? Integer.parseInt(version1Arr[i]) : 0;
            int ver2 = j<version2Arr.length ? Integer.parseInt(version2Arr[j]) : 0;
            
            if(ver1<ver2){
                return -1;
            }
            else if(ver1>ver2){
                return 1;
            }
            
            i++;
            j++;
        }
        
        return 0;
    }
}
