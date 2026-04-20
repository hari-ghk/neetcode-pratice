class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True

        stack = []
        for i in range(len(s)):
            if s[i] == '}' or s[i] == ']' or s[i] == ')':
                if (stack and not ((s[i] == ')' and stack[-1] == '(') or (s[i] == '}' and stack[-1] == '{') or (s[i] == ']' and stack[-1] == '['))) or not stack:
                    return False
                else:
                    stack.pop()
            else:
                stack.append(s[i])
        return True if len(stack) == 0 else False
                    


        