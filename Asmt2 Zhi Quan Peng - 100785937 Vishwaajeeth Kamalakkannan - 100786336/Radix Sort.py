import random
def countingSort(arr, exp):

    n = len(arr)
    result = [0] * (n)
    c = [0] * (10)

    for i in range(0, n):
        c[getDigit(arr[i], exp)] += 1

    for i in range(1, 10):
        c[i] += c[i - 1]

    i = n - 1
    while i >= 0:
        result[c[getDigit(arr[i], exp)] - 1] = arr[i]
        c[getDigit(arr[i], exp)] -= 1
        i -= 1
    
    for i in range(0, len(arr)):
        arr[i] = result[i]


def radixSort(arr, d):
    exp = 1
    while d >= 1:
        countingSort(arr, exp)
        exp *= 10
        d -= 1

def getDigit(num, d):
    digit = num // d
    return digit % 10


arr = [0] * 20

for x in range(20):
    arr[x] = random.randint(0, 999999)

radixSort(arr, 6)

for i in range(len(arr)):
    print(arr[i], end=" ")