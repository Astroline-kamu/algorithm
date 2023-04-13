# algorithm
一个在尝试的算法实现 ——不过我想给他改个名，叫尼雅德拉的奇思妙想！


# 使用框架 
[EChart java](https://echarts.icepear.org/#/zh-cn/overview) 
不得不说，EChart-java就是一个临时解决方案，本质上就是将数据丢给html，用echarts解决这个问题。不过再说了，对于大部分人来说，只要能下载下来图片其实就够了。

官网经常会崩，相比起来在gitlab的[仓库](https://github.com/ECharts-Java/ECharts-Java-Examples)都要比官网稳定的多，且目前官网中文基本上没内容，得看英文的。


# 结构

- leetcode 刷leetcode！
- graph 一些图表的实现
  - relationship 关系图表
    关于我本意想要构建的东西，通过重新布局来减少关系之间的交错连线的数量，我目前把这块的实现思路定义在拓扑学中，目前思路是通过定义闭环来区分节点组，利用节点组来做连线交叉的优化（想法），说到节点组，或许可以考虑用四差树来对一些已经固定的组进行整体的相同运算？（不太现实）
- TextSearch 一个文本搜索的代码
- 写到relationship的时候突然想给自己开个小坑，写一个二维平面的追踪系统（三纬大概就是再加上一个z轴向量），因为看起来java视图的性能貌似还蛮好的样子，顺便看看再写点儿碰撞啥的，会有趣很多。
