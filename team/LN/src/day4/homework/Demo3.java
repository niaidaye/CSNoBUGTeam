package src.day4.homework;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/13
 */

/*
[选做] 尝试阅读ArrayList源码。并描述过程
 */


public class Demo3 {
    public static void main(String[] args) {
         /*

       1 ：类声明和字段
       ArrayList是 Java集合框架的一个动态数组实现，位于
       “java . util” 包下：

        public class ArrayList <E> extends AbstractList <E>
        implements List <E> ,RandomAccess,Cloneable, java.io.Serializable

        ArrayList 实现了 List 接口 继承了 AbstractList 类
        同时也实现了 RandomAccess   表示支持快速随机访问
        和可克隆，可序列化等接口


         */


        /*
        2：常量和字段
        // 默认初始化容量
        private  static final int DEFAULT_CAPACITY = 10 ;

        // 空数组实例，用于空的ArrayList实例
        private  static final  Object [] EMPTY_ELEMENTDATA = {}


        // 储存元素的数组，transient关键字便是该字段不会被序列化
        transient Object [] elementData ;

        // ArrayList 中实际元素的数量
        private int size ;


         */
    }


}

