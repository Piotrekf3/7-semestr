import os.path
import random
users_number = 100
signatures_number = 100
mod = 10_000
rand = 0

def loadInput():
    dict = {}
    my_path = os.path.abspath(os.path.dirname(__file__))
    path = os.path.join(my_path, "../facts-nns.csv")
    with open(path, 'r') as file:
        for line in file:
            user, song = map(int, line.split(',', 2))
            if user not in dict:
                dict[user] = []
            dict[user].append(song)
    # for user in dict.keys():
    #     dict[user].sort()
    return dict

def hash(value):
    return (rand * value + 1) % mod

def newSignature(users):
    global rand
    signature = list()
    rand = random.randint(0, signatures_number)
    for i in range(1, users_number + 1):
        signature.append(min(map(hash, users[i])))
    return signature

def jaccardSimilarity(list1, list2):
    intersection = len(list(set(list1).intersection(list2)))
    union = (len(list1) + len(list2)) - intersection
    return float(intersection / union)

def getRealJaccard(users):
    similarity = {}
    for i in range(1, users_number + 1):
        for j in range(1, users_number + 1):
            similarity[(i, j)] = jaccardSimilarity(users[i], users[j])
    return similarity

def getEstimatedJaccard(signatures):
    similarity = {}
    for signature in signatures:
        for i in range(1, users_number + 1):
            for j in range(1, users_number + 1):
                if signature[i - 1] == signature[j - 1]:
                    similarity[(i, j)] = similarity.get((i, j), 0) + 1
    for key in similarity:
        similarity[key] /= signatures_number
    return similarity

def getRMSE(realValues, estimatedValues):
    result = 0
    for key in estimatedValues:
        result += (realValues[key] - estimatedValues[key])**2
    result /= len(estimatedValues)
    print(len(estimatedValues))
    return result

random.seed()
users = loadInput()

signatures = list()
for i in range(signatures_number):
    signatures.append(newSignature(users))
    print(i)

estimatedJaccard = getEstimatedJaccard(signatures)
# print(estimatedJaccard)
realJaccard = getRealJaccard(users)
# print(realJaccard)
print(getRMSE(realJaccard, estimatedJaccard))



