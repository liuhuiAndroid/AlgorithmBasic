荷兰国旗问题 
数组：<=x >x
设置<=区域，R表示右边界
1. 当前数<=目标数，把当前数和<=区的下一个数做交换，<=区域向右扩，当前数跳下一个
2. 当前数>目标，当前数跳下一个

数组：<x =x >x
1. 当前数<目标数，把当前数和<区的下一个数做交换，<区域向右扩，当前数跳下一个
2. 当前数=目标数，当前数跳下一个
3. 当前数>目标数，把当前数和>区的前一个数做交换，当前数停在原地

快排，拿数组的最后一个数作为目标，<x =x >x
先按照上面逻辑排序x前的数据，然后将x与>区的最后一个数做交换

快排1.0版本 时间复杂度O(N2)
<=x >x 且保证=x在<=x区域最右边，递归

快排2.0版本 时间复杂度O(N2)
数组中拿最右侧值来划分，<x =x >x，返回等于区域的下标

快排3.0版本 时间复杂度O(N*logN)
随机选择x

快排的额外空间复杂度