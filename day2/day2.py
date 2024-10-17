
if __name__=="__main__":
    data = [line.strip().split() for line in open("input.txt","r").readlines()]
    data = [(dir,int(x)) for dir, x in data]


    x = y = 0
    for dir,des in data:
        if dir == "forward":
            x += des
        if dir == "down":
            y += des
        if dir == "up":
            y -= des

    print(y*x)
