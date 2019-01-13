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
    for user in dict.keys():
        dict[user].sort()
    return dict

def hash(value):
    return (rand * value + 1) % mod

def newSignature(users):
    global rand
    signature = list()
    rand = random.randint(0, signatures_number)
    for user, songs in users.items():
       signature.append(min(map(hash, songs)))
    return signature


random.seed()
users = loadInput()

signatures = list()
for i in range(signatures_number):
    signatures.append(newSignature(users))
    print(i)
