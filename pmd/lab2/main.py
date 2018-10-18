from random import *
import itertools
from numpy.random import choice
import numpy as np
import matplotlib.pyplot as plt

def find_pairs(lst):
    return [(a,b) for a,b in itertools.permutations(lst, 2) if a==b]

n = 1000
p = 0.1
nh = 100
nd = 100
data = [[0 for x in range(n)] for y in range(nd)] 
terrorists = [[0 for x in range(n)] for y in range(n)] 
seed()

# for i in range(4):
#     for j in range(i):
#         print(i, j)


for day in range(nd):
    for man in range(n):
        if choice([True, False], p = [p, 1-p]):
            data[day][man] = randint(1, nh)

count = 0
for day in range(nd):
    for man in range(n):
        for man2 in range(man):
            if data[day][man] != 0 and man != man2 and data[day][man] == data[day][man2]:
                terrorists[man][man2] += 1
                if(terrorists[man][man2] == 2):
                    count+=1
# # print(terrorists)
print(count)
values, counts = np.unique(terrorists, return_counts=True)
print(values, counts)
plt.bar(values, counts, 0.5)
plt.xticks(values)
plt.show()




# count = 0
# for day in range(nd):
#     for man in range(n):
#         if choice([True, False], p = [p, 1-p]):
#             data[day][man] = randint(1, nh)
#         for man2 in range(man):
#             if data[day][man] != 0 and man != man2 and data[day][man] == data[day][man2]:
#                 terrorists[man][man2] += 1
#                 if(terrorists[man][man2] == 2):
#                     count+=1

# print(terrorists)
# print(count)
# plt.hist(terrorists)
# plt.show()