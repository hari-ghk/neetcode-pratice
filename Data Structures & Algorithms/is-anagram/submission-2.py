#clarifying questions
# 1. what does the string contain? - alphabets/numeric/special chars/spaces
# 2. if only characters? then lowercase/uppercase - are they treated the same or different
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s and not t:
            return True
        elif not s or not t or (len(s) != len(t)):
            return False

        char_map = {}
        for i in range(len(s)):
            if s[i] in char_map:
                char_map[s[i]] += 1
            else:
                char_map[s[i]] = 1

        for i in range(len(t)):
            if t[i] in char_map:
                char_map[t[i]] -= 1

        for key,value in char_map.items():
            if value != 0:
                return False
        return True