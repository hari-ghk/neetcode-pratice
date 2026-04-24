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
        for ch in s:
            char_map[ch] = char_map.get(ch,0) + 1

        for ch in t:
            if ch not in char_map:
                return False
            char_map[ch] -= 1

        return all(v == 0 for v in char_map.values())