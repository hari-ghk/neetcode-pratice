class Solution:
    def countBits(self, n: int) -> List[int]:
        if n == 0:
            return [0]

        def countOnes(num):
            count = 0
            while num > 0:
                if num % 2 == 1:
                    count += 1
                num //= 2
            return count

        res = []
        for i in range(n+1):
            res.append(countOnes(i))
        return res