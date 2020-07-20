# TDD-Android

# TDD

一次只写一个刚好失败的测试，作为新加功能的描述；
不写任何产品代码，除非它刚好能让失败着的测试通过；
只在测试全部通过的前提下，开始新加功能或重构代码。

![](/pic/tdd.png)

# 需求分析
 
![](/pic/request.png)

# 简单设计

![](/pic/design.png)

# 任务拆解

1. 通过Retrofit拿到服务的新闻列表数据
2. Repository进行服务数据封装
3. 定义ViewModel层，通过Repository拿到数据，并且生成一个LiveData的数据
4. 定义Activity，通过LiveData的数据进行页面绑定展示
