# -*- coding: utf-8 -*-

class com.leetcode.tip22DS_.Solution:
  def isValid(self, s):
    if not s or len(s) == 0:
      return True
    if len(s) % 2 == 1:
      return False
    
    t = []
    for c in s:
      if c == '(':
        t.append(c)
      elif c == ')':
        if len(t) == 0:
          return False
        t.pop()
      else:
        return False
    return len(t) == 0

solution = com.leetcode.tip22DS_.Solution()

assert solution.isValid("")
assert not solution.isValid("(")
assert not solution.isValid(")")

assert solution.isValid("()")
assert not solution.isValid("((")
assert not solution.isValid("))")
assert not solution.isValid(")(")

assert not solution.isValid("())")
assert not solution.isValid("(((")
assert not solution.isValid(")))")
assert not solution.isValid(")()")

assert solution.isValid("()()")
assert solution.isValid("(())")
assert not solution.isValid("))((")

assert solution.isValid("()()()")
assert solution.isValid("((()))")
assert solution.isValid("()(())")
assert not solution.isValid("()(()(")