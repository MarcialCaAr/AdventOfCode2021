global aux
global count
count = 0
if __name__ == "__main__":
    data = [int(line) for line in open("input.txt","r").readlines()]

    aux = data[0]
    for line in data:
        if line > aux:
            count += 1
        aux = line

    print(count)