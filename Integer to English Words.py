class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        lv1 = "Zero One Two Three Four Five Six Seven Eight Nine Ten \
               Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split()
        lv2 = "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split()
        lv3 = "Hundred"
        lv4 = "Thousand Million Billion".split()
        words, digits = [], 0
        while num:
            token, num = num % 1000, num / 1000
            word = ''
            if token > 99:
                word += lv1[token / 100] + ' ' + lv3 + ' '
                token %= 100
            if token > 19:
                word += lv2[token / 10 - 2] + ' '
                token %= 10
            if token > 0:
                word += lv1[token] + ' '
            word = word.strip()
            if word:
                word += ' ' + lv4[digits - 1] if digits else ''
                words += word,
            digits += 1
        return ' '.join(words[::-1]) or 'Zero'
        
