import math
def calculate(left, right, cuts):

    if (left > right):
        return 0
    
    minNumber = math.inf
    cost = 0
    
    for x in range (left, right+1):
        cost = cuts[right + 1] - cuts[left - 1] + calculate(left, x - 1, cuts) + calculate(x + 1, right, cuts)
        minNumber = min(minNumber, cost)
    return minNumber

def minCost(length, cuts):
    cuts.insert(0,0)
    cuts.append(length)
    cuts.sort()
    return calculate(1, len(cuts) - 2, cuts)

length = 16
cuts = [7,8,9]
print("Dynamic:", minCost(length, cuts))