import math
def calculate(cuts):

    mid = len(cuts) // 2
    if (len(cuts) > 2):
        return cuts[-1] - cuts[0] + calculate(cuts[mid:]) + calculate(cuts[:mid+1])
    else:
        return 0
        

def minCost(length, cuts):
    cuts.insert(0,0)
    cuts.append(length)
    cuts.sort()
    return calculate(cuts)

length = 16
cuts = [7,8,9]
print("Greed:", int(minCost(length, cuts)))