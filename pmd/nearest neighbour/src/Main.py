users_number = 100


def loadInput():
    dict = {}
    with open('../facts-nns.csv', 'r') as file:
        for line in file:
            user, song = map(int, line.split(',', 2))
            if user not in dict:
                dict[user] = []
            dict[user].append(song)
    return dict

dict = loadInput()

def intersection(list1, list2):
    temp = set(list2)
    list3 = [value for value in list1 if value in temp]
    return list3

def jaccart_measure(list1, list2):
    # intersection_len = len(intersection(list1, list2))
    # union_len = len(list1) + len(list2) - intersection_len
    intersection_len = len(set(list1).intersection(list2))
    union_len = len(set(list1).union(list2))
    return intersection_len/union_len

users = 0;
jaccart = {}
for user, songs in dict.items():
    if users < users_number:
        print(users)
        jaccart[user] = {}
        for neighbour, songs2 in dict.items():
            try:
                jaccart[user][neighbour] = jaccart[neighbour][user]
            except:
                jaccart[user][neighbour] = jaccart_measure(songs,songs2)
                pass
        users += 1

for user, neighbour in jaccart.items():
    sorted_by_value = sorted(neighbour.items(), key=lambda kv: kv[1], reverse=True)
    print(sorted_by_value[:100])