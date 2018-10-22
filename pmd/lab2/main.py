from random import *
from itertools import combinations
import numpy as np
import matplotlib.pyplot as plt
import time

def compute(n, p, nh, nd):
    terrorists = 0
    pairs = {}

    for day in range(nd):
        # print(day)
        hotels = {}
        for man in range(n):
            # print("man=" + str(man))
            if randint(1, p) == 1:
                hotel = randint(1, nh)
                if hotel not in hotels.keys():
                    hotels[hotel] = []
                hotels[hotel].append(man)
        for hotel, visitors in hotels.items():
            for vis1, vis2 in combinations(visitors, 2):
                pair = str(vis1) + '-' + str(vis2)
                pairs[pair] = pairs.get(pair, 0) + 1

    distinctPersons = set()
    pairs_days_count_result = 0
    for pair, count in pairs.items():
        if count > 1:
            terrorists += 1
            pairs_days_count_result += len(list(combinations(range(count), 2)))
            person1, person2 = pair.split('-')
            distinctPersons.add(person1)
            distinctPersons.add(person2)

    values, counts = np.unique(list(pairs.values()), return_counts=True)
    return [terrorists, len(distinctPersons), counts, pairs_days_count_result]

def main():
    n = 10000
    p = 10
    nh = 100
    nd = 100
    iterations = 5
    seed()

    terrorists = 0
    daysPairs = 0
    distinctPersons = 0
    counts = [0, 0, 0]

    for i in range(iterations):
        a, b, c, d = compute(n, p, nh, nd)
        terrorists += a
        distinctPersons += b
        counts = [x + y for x, y in zip(counts, c)]
        daysPairs += d

    counts = [x/iterations for x in counts]

    print("Podejrzane pary: " + str(terrorists/iterations))
    print("Podejrzane pary osób i dni: " + str(daysPairs/iterations))
    print("Podejrzane osoby: " + str(distinctPersons/iterations))
    print("Histogram: " + str(counts))

    values = range(1, len(counts) + 1)
    plt.bar(values, counts, 0.5)
    plt.xticks(values)
    plt.show()

if __name__ == "__main__":
    main()
# plt.hist(terrorists)
# plt.show()