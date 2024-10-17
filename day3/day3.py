global gamma_rate 
gamma_rate = ""
global epsilon_rate 
epsilon_rate = ""

global ceros
ceros = []
global unos
unos = []


def recorrer(data):
    global count
    global unos
    global ceros
    for i in data[1]:
        unos.append(0)
        ceros.append(0)

    for val in data:
        for i,bit in enumerate(val):
            if bit == "1":
                unos[i] += 1
            else:
                ceros[i] += 1



def mayoritario(un, ce):
    global gamma_rate
    global epsilon_rate
    for u,c in zip(un,ce):
        if u > c:
            gamma_rate += "1"
            epsilon_rate += "0"
        else:
            gamma_rate += "0"
            epsilon_rate += "1"




if __name__=="__main__":
    data = [line.strip() for line in open("input.txt","r").readlines()]
    recorrer(data)
    mayoritario(unos, ceros)

    print(int(gamma_rate,2) * int(epsilon_rate,2))