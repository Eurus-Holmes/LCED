class Solution(object):
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        h = len(board)
        w = len(board[0]) if h else 0
        
        ans = 0
        for x in range(h):
            for y in range(w):
                if board[x][y] == "X":
                    if x > 0 and board[x-1][y] == "X":
                        continue
                    if y > 0 and board[x][y-1] == "X":
                        continue
                    
                    ans += 1
                    
                    
        return ans
        
