from os.path import join, dirname
import heapq

class Node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq

        self.symbol = symbol

        self.left = left

        self.right = right

        self.path = ''

    def __lt__(self, nxt):
        return self.freq < nxt.freq

def readFile(fileName):
    frequent = dict()
    path = join(dirname(__file__), fileName)
    with open(path, 'r') as file:
        text = file.read()
        for letter in text:
            if frequent.get(letter) == None:
                frequent[letter] = 1
            else:
                frequent[letter] += 1  

    return frequent

def huffman(C):
    nodes = []

    for key, val in C.items():
        heapq.heappush(nodes, Node(val,key))

    while len(nodes) > 1:
        left = heapq.heappop(nodes)
        right = heapq.heappop(nodes)

        left.path = 0
        right.path = 1

        newNode = Node(left.freq+right.freq, left.symbol+right.symbol, left, right)

        heapq.heappush(nodes, newNode)
    
    return nodes[0]

def display(nodes, val=''):
    newVal = val + str(nodes.path)
    if(nodes.left):
        display(nodes.left, newVal)
    if(nodes.right):
        display(nodes.right, newVal)

    if(not nodes.left and not nodes.right):
        print(f"{nodes.symbol} -> \t{newVal} \tfreq: {nodes.freq}")
        
def sumAfter(nodes):
    sum = 0
    listOfNodes = [nodes]

    while len(listOfNodes) > 0:
        current = listOfNodes.pop()
        if current.symbol is not None:
            sum += current.freq * len(str(current.path))
        if current.right is not None:
            listOfNodes.append(current.right)
        if current.left is not None:
            listOfNodes.append(current.left)

    return sum
    
    
C = readFile("test.txt")
nodes = huffman(C)
print()
display(nodes)
print(f"Before {nodes.freq * 8} bits -> After {sumAfter(nodes)}")
