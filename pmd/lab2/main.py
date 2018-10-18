from random import *
import itertools
from numpy.random import choice

def find_pairs(lst):
    return [(a,b) for a,b in itertools.permutations(lst, 2) if a==b]

n = 10
p = 0.1
nh = 100
nd = 100
data = [[0 for x in range(n)] for y in range(nd)] 
terrorists = [[0 for x in range(n)] for y in range(n)] 
seed()

for day in range(nd):
    for man in range(n):
        if choice([True, False], p = [p, 1-p]):
            data[day][man] = randint(1, nh)
for day in range(nd):
    for man in range(n):
        for man2 in range(n):
            if data[day][man] == data[day][man2]
                terrorists[day][man] += 1