# This program is designed to show new users
# how to do simple arrays, summation using
# array elements and concatenation of string
# and integer types, with no math libraries.
#
# @Author: Jaime Guevara - Team OWLS
a = [1,2,3,4,5] 

x = a[1] + a[4]
y = a[0] + a[-2]

print('This is a simple Python program about\n'
      'arrays and indexing\n\n'
      'Author: Jaime Guevara'
      '\nTeam: Owls\n')
print('\nLet\'s say we have a starting array:\n')
print('a = ' + str(a) + '\n')
print('\nNow we can use a\'s elements to do some simple addition!\n'
      '\nWe can call on a\'s elements using natural indexing:\n' 
      '    x = a[1] + a[4] = ' + str(x) + '\n'
      '\nOr we can call on them from the tail end\n'
      'using negative indexing:\n'
      '    y = a[0] + a[-2] = ' + str(y) + '\n')

