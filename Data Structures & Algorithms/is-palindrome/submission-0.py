class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        if not str:
            return True

        trimStr = "".join(ch for ch in s if ch.isalnum())
        trimStr = trimStr.lower()
    
        i = 0
        j = len(trimStr) - 1
        
        while i < j:
            if trimStr[i] != trimStr[j]:
                return False
            else:
                i += 1
                j -= 1
        return True