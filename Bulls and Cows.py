class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        bull = sum(map(operator.eq, secret, guess))
        sa = collections.Counter(secret)
        sb = collections.Counter(guess)
        cow = sum((sa & sb).values()) - bull
        return str(bull) + 'A' + str(cow) + 'B'
        
