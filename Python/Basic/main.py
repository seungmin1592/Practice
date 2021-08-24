print('================= variable ======================')
a_string = 'like this'
a_number = 3
a_float = 3.12
a_boolean = False
a_none = None 

print("")
print('================= list ======================')
# list (mutuble)
days = ["Mon","Tue","Wed","Thur","Fri"]

print("Mon" in days)
print(days)
days.append("Sat")
print(days)
print(len(days))
days.reverse()
print(days)


print("")
print('================= tuple ======================')
#tuple (immutuble)
days2 = ("Mon","Tue","Wed","Thur","Fri")

print(type(days2))


print("")
print('================= dictionnary ======================')
#dictionnary (key : value)
info = {
  "name":"seungmin",
  "age":25,
  "korean":True,
  "fav_food":["kimchi","pizza"]
}

print(info)


print("")
print('================= fucntion ======================')
# function
age = "18"
print(type(age))
n_age = int(age)
print(age)
print(type(n_age))


print("")
print('================= fucntion ======================')
# function 생성 방법
# python의 function은 {} 없이 들여쓰기로 function에 포함 여부를 판단한다
def say_hello():
  print("hello") # say_hello function에 포함
print("bye") # say_hello function에 포함 x

say_hello()

#매개변수를 받는 function
def say_hello(who):
  print("hello", who)

say_hello("seungmin")


# 매겨변수에 기본값(Default)을 지정할 수 있음
def plus(a, b=1):
  print(a + b);

plus(2)

# function return
def r_plus(a, b):
  return(a + b);

r_result = r_plus(2,5)
print(r_result)


# fomatting
def say_hello2(name, age):
  return f"Hello {name} you are {age} years old"

hello = say_hello2("seungmin", "25")
print(hello)

# function 매개변수(name / value)
hello2 = say_hello2(age = "22", name = "kim")
print(hello2) 



print("")
print('================= if/else ======================')
# if/else
def plus1(a, b):
  if type(b) is int or type(b) is float:
    return a + b
  else :
    return None

print(plus1(1,2))
print(plus1(1,'2'))


print("")
print('================= elif ======================')
def age_check(age) :
  print(f"you are {age}")
  if age < 18 :
    print("you can drink")
  elif age == 18 : 
    print("you are new to this")
  elif age > 20 and age < 25:
    print("you are still kind of young")
  else :
    print("enjoy your drink")

age_check(40)  


print("")
print('================= for ======================')
days1 = ["Mon","Tue","Wed","Thur","Fri"]

for day in days1:
  if day is "Wed":
    break
  else :
    print(day)


print("")
print('================= module ======================')

#import math
from math import ceil, fsum

print(ceil(1.2))
print(sum([3,4]))