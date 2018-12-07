# 原题
在一条环形的路上有N个加油站，每个加油站里有gas[i]的汽油，从第i个加油站到第i+1个加油站需要花费cost[i]的汽油。假设汽车的油箱可以装无数的汽油，判断一辆没有油的汽车是否可以从其中的某一个加油站出发并行驶一圈后返回该加油站。如果可以的话，返回起始加油站的下标，否则返回-1。

注意点：

  - 如果有答案的话，答案是唯一的
  - 不用考虑逆向行驶

例子:

```
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
```

# 解题思路
用两个变量存+= gas[i] - cost[i]。一个帮助判断当前这个点作为gas station的起点合不合适，
一个帮助判断总的需求是不是大于供给。如果总的需求大于供给那么肯定是无解的，如果需求小于等于供给，就可以返回刚才找到的起始点。



