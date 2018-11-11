# This program will show how tables can
# be created and transformed by using
# user input as the parameters for the tables
import numpy as np

print("This program teaches you about table"
        " transformation based on your input"
        " and by using the Numpy library\n")

row = input("Select a number of rows: ")
col = input("\nNow select a number of columns: ")

print("\nNow that we have these numbers, we can produce a table using Python."
        " We can produce one filled with zeros using numpy:\n\n>>>table = numpy.zeros((row,col))\n\n"
        "*Numpy is a Python library that you'll have to import")

table = np.zeros((int(row),int(col)))

print("Doing this yields the following table:\n")
print(table)

print("\nNow that we have our table, we can start populating it.\n")

for x in range(int(row)):
    for y in range(int(col)):
        table[x][y] = y

print(table)

print("\nWe can also use numpy to transpose our table\n")

transposed = np.transpose(table)

print(transposed)

print("\nTables can also use the numpy.reshape function to change"
        " the layout of its contents (such as by swapping row and column numbers)"
        ", though the new shape must"
        " contain the same number of elements as the original\n")

#total = int(row) * int(col)
reshaped = np.reshape(table,(int(col),int(row)))

print(reshaped)

print("\nNumpy can also be used to change the contents of our table and its shape\n")

table = np.arange(int(row)*int(col)).reshape((int(row),int(col)))
table2 = np.arange(int(row)*int(col)).reshape((int(col),int(row)))

total = int(row) * int(col)

print(row + "X" + col + " table with elements over the range of 0 to " + str(total) + ":\n")
print(table)
print("\n" + col + "X" + row + " table with elements over the range of 0 to " + str(total) + ":\n")
print(table2)
