public class Solution {
    public boolean isNumber(String s) {
        if(s==null)
            return false;
        s = s.trim();
        if(s.length()==0)
            return false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i=0;i<s.length();i++)
        {
            switch(s.charAt(i))
            {
                case '.':
                    if(dotFlag || eFlag 
                    || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')) 
                        && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))))
                        return false;
                    dotFlag = true;
                    break;
                case '+':
                case '-':
                    if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
                      || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.')))
                        return false;
                    break;
                case 'e':
                case 'E':
                    if(eFlag || i==s.length()-1 || i==0)
                        return false;
                    eFlag = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
