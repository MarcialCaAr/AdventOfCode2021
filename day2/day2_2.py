if __name__=="__main__":
    data = [line.strip().split() for line in open("input.txt","r").readlines()]
    data = [(dir,int(x)) for dir, x in data]


    x = aim = y = 0
    for dir,des in data:
        if dir == "forward":
            x += des
            y += aim * des
        if dir == "down":
            aim += des
        if dir == "up":
            aim -= des

    print(y*x)