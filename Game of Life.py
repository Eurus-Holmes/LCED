class Solution(object):
    
    def countLiveNeighbors(self, i, j, m, n, board):
        dx = [1, 1, 1, 0, 0, -1, -1, -1]
        dy = [1, 0, -1, 1, -1, 1, 0, -1]
        cnt = 0
        for k in xrange(8):
            nx, ny = i + dx[k], j + dy[k]
            if nx < 0 or ny < 0 or nx >= m or ny >= n: continue
            if board[nx][ny] == 1:
                cnt += 1
        return cnt
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        temp = copy.deepcopy(board)
 
        m, n = len(board), len(board[0])
        for i in xrange(m):
            for j in xrange(n):
                cnt = self.countLiveNeighbors(i, j, m, n, temp)
                if temp[i][j]:
                    if not (cnt == 2 or cnt == 3):  board[i][j] = 0
                else:  # temp[i][j] ==0
                    if cnt == 3: board[i][j] = 1

                        
                        
                        
                        
                        
                        
                        
# Follow Up 1                   
# class Solution(object):
    
#     def countLiveNeighbors(self, i, j, m, n, board):
#         dx = [1, 1, 1, 0, 0, -1, -1, -1]
#         dy = [1, 0, -1, 1, -1, 1, 0, -1]
#         cnt = 0
#         for k in xrange(8):
#             nx, ny = i + dx[k], j + dy[k]
#             if nx < 0 or ny < 0 or nx >= m or ny >= n: continue
#             if board[nx][ny] == 1 or board[nx][ny] == 2: cnt += 1
 
#         return cnt
    
#     def gameOfLife(self, board):
#         """
#         :type board: List[List[int]]
#         :rtype: None Do not return anything, modify board in-place instead.
#         """
#         m, n = len(board), len(board[0])
#         for i in xrange(m):
#             for j in xrange(n):
#                 cnt = self.countLiveNeighbors(i, j, m, n, board)
#                 if board[i][j]:
#                     if not (cnt == 2 or cnt == 3):  board[i][j] = 2
#                 else:  # temp[i][j] ==0
#                     if cnt == 3: board[i][j] = 3
 
#         for i in xrange(m):
#             for j in xrange(n):
#                 board[i][j] = board[i][j] & 1
                
        
