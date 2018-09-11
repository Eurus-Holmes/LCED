class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        point = "."
        for i in range(9):
            row = []
            column = []
            square = []
            for j in range(9):
                element = board[i][j]
                if element != point:
                    if element in row:
                        return False
                    else:
                        row.append(element)

                element = board[j][i]
                if element != point:
                    if element in column:
                        return False
                    else:
                        column.append(element)

                element = board[i // 3 * 3 + j // 3][i % 3 * 3 + j % 3]
                if element != point:
                    if element in square:
                        return False
                    else:
                        square.append(element)
        return True
