class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length<=1 || board[0].length<=1)
        return;
    
    //第一行和最后一行进行fill
    for(int i=0;i<board[0].length;i++){
        fill(board,0,i);
        fill(board,board.length-1,i);
    }
    
    //第一列和最后一列进行fill
    for(int i=0;i<board.length;i++){
        fill(board,i,0);
        fill(board,i,board[0].length-1);
    }
    
    //对于当前格子中，所有O变成X（说明符合要求，没有被变成#),所有#变成O
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O')
                board[i][j]='X';
            else if(board[i][j]=='#')
                board[i][j]='O';     
            }
        }
    }

    private void fill(char[][] board, int i, int j){
        if(board[i][j]!='O')
            return;
        board[i][j] = '#';
        //利用BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //先将矩阵的横纵坐标编码
        int code = i*board[0].length+j;
        queue.add(code);
        while(!queue.isEmpty()){
            code = queue.poll();
            int row = code/board[0].length;//从code中还原横坐标
            int col = code%board[0].length;//从code中还原纵坐标
        
            if(row>=1 && board[row-1][col]=='O'){//当前元素上边是否为0
                queue.add((row-1)*board[0].length + col);
                board[row-1][col]='#';
            }
        
            if(row<=board.length-2 && board[row+1][col]=='O'){//当前元素下面是否为0
                queue.add((row+1)*board[0].length + col);
                board[row+1][col]='#';
            }
        
            if(col>=1 && board[row][col-1]=='O'){//当前元素左边是否为0
                queue.add(row*board[0].length + col-1);
                board[row][col-1]='#';
            }
        
            if(col<=board[0].length-2 && board[row][col+1]=='O'){//当前元素右边是否为0
                queue.add(row*board[0].length + col+1);
                board[row][col+1]='#';
            }            
        }
    }
}
