异或运算 无进位相加

a ^ b = b ^ a
a ^ (b ^ c) = (a ^ b) ^ c

a = a ^ b
b = a ^ b
a = a ^ b

怎么把一个int类型的数，提取出最右侧的1
a & (~a + 1) = a & (-a)