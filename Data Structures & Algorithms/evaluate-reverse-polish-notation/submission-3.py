class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for i in range(len(tokens)):
            token = tokens[i]
            if token == '/' or token == '+' or token == '*' or token == '-':
                if len(stack) > 1:
                    op2 = int(stack.pop()) 
                    op1 = int(stack.pop()) 
                else:
                    return 0

                if token == '/':
                    stack.append(op1 / op2)
                elif token == '+':
                    stack.append(op1 + op2)
                elif token == '*':
                    stack.append(op1 * op2) 
                else:                   
                    stack.append(op1 - op2) 

            else:
                stack.append(token)
                
        return int(stack[-1]) if stack else 0