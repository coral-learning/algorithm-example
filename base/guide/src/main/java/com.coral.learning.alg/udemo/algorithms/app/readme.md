集合类存放于java.util包中。
集合类存放的都是对象的引用，而非对象本身，出于表达上的便利，我们称集合中的对象就是指集合中对象的引用（reference)。
集合类型主要有3种：set(集）、list(列表）和map(映射)。
集合接口分为：Collection和Map，list、set实现了Collection接口

在使用Java的时候，我们都会遇到使用集合（Collection）的时候，但是Java API提供了多种集合的实现，我在使用和面试的时候频频遇到这样的“抉择” 。 :）
（主要还是面试的时候）久而久之，也就有了一点点的心得体会，写出来以供大家讨论 。

总的说来，Java API中所用的集合类，都是实现了Collection接口，他的一个类继承结构如下：
```java
Collection<--List<--Vector
Collection<--List<--ArrayList
Collection<--List<--LinkedList
Collection<--Set<--HashSet
Collection<--Set<--HashSet<--LinkedHashSet
Collection<--Set<--SortedSet<--TreeSet
```


**Vector :** 
基于Array的List，其实就是封装了Array所不具备的一些功能方便我们使用，它不可能走出Array的限制。性能也就不可能超越Array。所以，在可能的情况下，我们要多运用Array。另外很重要的一点就是Vector“synchronized”的，这个也是Vector和ArrayList的唯一的区别。ArrayList：同Vector一样是一个基于数组实现的，但是不同的是ArrayList不是同步的。所以在性能上要比Vector优越一些，但是当运行到多线程环境中时，可需要自己在管理线程的同步问题。LinkedList：LinkedList不同于前面两种List，它不是基于Array的，所以不受Array性能的限制。它每一个节点（Node）都包含两方面的内容：1.节点本身的数据（data）；2.下一个节点的信息（nextNode）。所以当对LinkedList做添加，删除动作的时候就不用像基于Array的List一样，必须进行大量的数据移动。只要更改nextNode的相关信息就可以实现了。这就是LinkedList的优势。
List总结编辑
1. 所有的List中只能容纳单个不同类型的对象组成的表，而不是Key－Value键值对。例如：[ tom,1,c ]；
2. 所有的List中可以有相同的元素，例如Vector中可以有 [ tom,koo,too,koo ]；
3. 所有的List中可以有null元素，例如[ tom,null,1 ]；
4. 基于Array的List（Vector，ArrayList）适合查询，而LinkedList（链表）适合添加，删除操作。
HashSet：虽然Set同List都实现了Collection接口，但是他们的实现方式却大不一样。List基本上都是以Array为基础。但是Set则是 在HashMap的基础上来实现的，这个就是Set和List的根本区别。HashSet的存储方式是把HashMap中的Key作为Set的对应存储项。看看 HashSet的add（Object obj）方法的实现就可以一目了然了。
public boolean add(Object obj)
{
return map.put(obj, PRESENT) == null;
}
这个也是为什么在Set中不能像在List中一样有重复的项的根本原因，因为HashMap的key是不能有重复的。
LinkedHashSet：HashSet的一个子类，一个链表。
TreeSet：SortedSet的子类，它不同于HashSet的根本就是TreeSet是有序的。它是通过SortedMap来实现的。（HashSet是无序的,TreeSet是有序的）
Set总结编辑
1. Set实现的基础是Map（HashMap）；
2. Set中的元素是不能重复的，如果使用add(Object obj)方法添加已经存在的对象，则会覆盖前面的对象
为什么要使用集合类
当你事先不知道要存放数据的个数，或者你需要一种比数组下标存取机制更灵活的方法时，你就需要用到集合类。
理解集合类
集合类存放于java.util包中。
集合类存放的都是对象的引用，而非对象本身，出于表达上的便利，我们称集合中的对象就是指集合中对象的引用（reference)。
集合类型主要有3种：set(集）、list(列表）和map(映射)。
(1)集
集（set）是最简单的一种集合，它的对象不按特定方式排序，只是简单的把对象加入集合中，就像往口袋里放东西。
对集中成员的访问和操作是通过集中对象的引用进行的，所以集中不能有重复对象。
集也有多种变体，可以实现排序等功能，如TreeSet，它把对象添加到集中的操作将变为按照某种比较规则将其插入到有序的对象序列中。它实现的是SortedSet接口，也就是加入了对象比较的方法。通过对集中的对象迭代，我们可以得到一个升序的对象集合。
(2)列表
列表的主要特征是其对象以线性方式存储，没有特定顺序，只有一个开头和一个结尾，当然，它与根本没有顺序的集是不同的。
列表在数据结构中分别表现为：数组和向量、链表、堆栈、队列。
关于实现列表的集合类，是我们日常工作中经常用到的，将在后边的笔记详细介绍。
(3)映射
映射与集或列表有明显区别，映射中每个项都是成对的。映射中存储的每个对象都有一个相关的关键字（Key）对象，关键字决定了 对象在映射中的存储位置，检索对象时必须提供相应的关键字，就像在字典中查单词一样。关键字应该是唯一的。
关键字本身并不能决定对象的存储位置，它需要对过一种散列(hashing)技术来处理，产生一个被称作散列码(hash code)的整数值，
散列码通常用作一个偏置量，该偏置量是相对于分配给映射的内存区域起始位置的，由此确定关键字/对象对的存储位置。理想情况 下，散列处理应该产生给定范围内均匀分布的值，而且每个关键字应得到不同的散列码。
集合类简介
java.util中共有13个类可用于管理集合对象，它们支持集、列表或映射等集合，以下是这些类的简单介绍
集：
HashSet： 使用HashMap的一个集的实现。虽然集定义成无序，但必须存在某种方法能相当高效地找到一个对象。使用一个HashMap对象实现集的存储和检索操作是在固定时间内实现的.
TreeSet： 在集中以升序对对象排序的集的实现。这意味着从一个TreeSet对象获得第一个迭代器将按升序提供对象。TreeSet类使用 了一个TreeMap.
列表：
Vector： 实现一个类似数组一样的表，自动增加容量来容纳你所需的元素。使用下标存储和检索对象就象在一个标准的数组中一样 。你也可以用一个迭代器从一个Vector中检索对象。Vector是唯一的同步容器类??当两个或多个线程同时访问时也是性能良好的。
Stack: 这个类从Vector派生而来，并且增加了方法实现栈??一种后进先出的存储结构。
LinkedList: 实现一个链表。由这个类定义的链表也可以像栈或队列一样被使用。
ArrayList: 实现一个数组，它的规模可变并且能像链表一样被访问。它提供的功能类似Vector类但不同步。
映射：
Hashtable： 实现一个映象，所有的键必须非空。为了能高效的工作，定义键的类必须实现hashcode()方法和equal()方法。这个类 是前面java实现的一个继承，并且通常能在实现映象的其他类中更好的使用。
HashMap： 实现一个映象，允许存储空对象，而且允许键是空（由于键必须是唯一的，当然只能有一个）。
WeakHashMap： 实现这样一个映象：通常如果一个键对一个对象而言不再被引用，键/对象对将被舍弃。这与HashMap形成对照，映象 中的键维持键/对象对的生命周期，尽管使用映象的程序不再有对键的引用，并且因此不能检索对象。
TreeMap： 实现这样一个映象，对象是按键升序排列的。
Set和List都是由公共接口Collection扩展而来，所以它们都可以使用一个类型为Collection的变量来引用。这就意味着任何列表或集构成的集合都可以用这种方式引用，只有映射类除外（但也不是完全排除在外，因为可以从映射获得一个列表。）所以说，把一个
列表或集传递给方法的标准途径是使用Collection类型的参数。
Vector 还是ArrayList，哪一个更好，为什么？
要回答这个问题不能一概而论，有时候使用Vector比较好；有时是ArrayList，有时候这两个都不是最好的选择。你别指望能够获得 一个简单肯定答案，因为这要看你用它们干什么。下面有4个要考虑的因素：
(1)API
(2)同步处理
(3)数据增长性
(4)使用模式
下面针对这4个方面进行一一探讨
API编辑
在由Ken Arnold等编著的《Java Programming Language》(Addison-Wesley, June 2000)一书中有这样的描述，Vector类似于 ArrayList.。所有从API的角度来看这两个类非常相似。但他们之间也还是有一些主要的区别的。
同步性
Vector是同步的。这个类中的一些方法保证了Vector中的对象是线程安全的。而ArrayList则是异步的，因此ArrayList中的对象并不是线程安全的。因为同步的要求会影响执行的效率，所以如果你不需要线程安全的集合那么使用ArrayList是一个很好的选择，这样可以避免由于同步带来的不必要的性能开销。
数据增长
从内部实现机制来讲ArrayList和Vector都是使用数组(Array)来控制集合中的对象。当你向这两种类型中增加元素的时候，如果元素 的数目超出了内部数组目前的长度它们都需要扩展内部数组的长度，Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%,所以最后你获得的这个集合所占的空间总是比你实际需要的要大。所以如果你要在集合中保存大量的数据那么使用Vector 有一些优势，因为你可以通过设置集合的初始化大小来避免不必要的资源开销。
使用模式编辑
在ArrayList和Vector中，从一个指定的位置（通过索引）查找数据或是在集合的末尾增加、移除一个元素所花费的时间是一样的，这个时间我们用O(1)表示。但是，如果在集合的其他位置增加或移除元素那么花费的时间会呈线形增长：O(n-i)，其中n代表集合中元素的个数，i代表元素增加或移除元素的索引位置。为什么会这样呢？以为在进行上述操作的时候集合中第i和第i个元素之后的所有元素都要执行位移的操作。这一切意味着什么呢？
这意味着，你只是查找特定位置的元素或只在集合的末端增加、移除元素，那么使用Vector或ArrayList都可以。如果是其他操作，你最好选择其他的集合操作类。比如，LinkList集合类在增加或移除集合中任何位置的元素所花费的时间都是一样的—O(1)，但它在 索引一个元素的使用却比较慢－O(i),其中i是索引的位置.使用ArrayList也很容易，因为你可以简单的使用索引来代替创建iterator 对象的操作。LinkList也会为每个插入的元素创建对象，所有你要明白它也会带来额外的开销。
最后，在《Practical Java》一书中Peter Haggar建议使用一个简单的数组（Array）来代替Vector或ArrayList。尤其是对于执行效 率要求高的程序更应如此。因为使用数组(Array)避免了同步、额外的方法调用和不必要的重新分配空间的操作。