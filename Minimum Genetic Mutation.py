class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        bfs = collections.deque()
        bfs.append((start, 0))
        bankset = set(bank)
        while bfs:
            gene, step = bfs.popleft()
            if gene == end:
                return step
            for i in range(len(gene)):
                for x in "ACGT":
                    newGene = gene[:i] + x + gene[i+1:]
                    if newGene in bank and newGene != gene:
                        bfs.append((newGene, step + 1))
                        bank.remove(newGene)
        return -1

