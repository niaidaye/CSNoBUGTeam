package DayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/12 2:10 PM
 * @Description: TODO
 */
//ArrayList的运用
/*创建一个空的ArrayList，然后依次添加以下元素： "Apple", "Banana", "Cherry", "Date"。
在列表的第二个位置插入 "Grape"。
使用循环打印出列表中的每个元素。
检查列表是否包含 "Banana"，如果包含，则删除它。
将列表中的所有元素清空。*/
public class Demo {
    public static void main(String[] args) {
//创建一个ArrayList数组
        ArrayList<fruits> fruitsList=new ArrayList<>();
        //一次添加水果
        fruitsList.add(new fruits("apple",203,"china"));//1
        fruitsList.add(new fruits("bannana",120,"japan"));//2
        fruitsList.add(new fruits("origin",220,"usa"));//3
        fruitsList.add(new fruits("watermelon",23,"canada"));//4
        //插入水果“Grape”在橘子后面
        fruits grape=new fruits("grape",380,"asutrilia");

        fruitsList.add(2,grape);
        //打印列表
        System.out.println(fruitsList);
        //现在检查是有包含bannana水果，如果有删去
        //可以考虑用iterator迭代器遍历查询后删去
//        for (fruits f:fruitsList
//             ) {
//            if((f.getName().equals("bannana"))){
//                fruitsList.remove(f);
//
//            }
////此时做删除操作后，影响后面数组下标，因此会发生可能导致 ConcurrentModificationException 异常。
//            //为了避免这种情况，我们可以采用迭代器遍历
//
//            System.out.println(f);
//        }
        // 现在检查是否包含bannana水果，如果有则删除
        // 使用迭代器进行遍历和删除
        Iterator<fruits> iterator = fruitsList.iterator();
        while (iterator.hasNext()) {
            fruits f = iterator.next();
            if (f.getName().equals("bannana")) {
                iterator.remove();
            }
        }

        // 重新打印列表
        System.out.println("After removing 'bannana':");
        for (fruits f : fruitsList) {
            System.out.println(f);
        }


//清空列表
fruitsList.clear();
        System.out.println(fruitsList.size());
    }
}
class fruits{
    String name;
    int price;
    String producelocation;

    public fruits(String name, int price, String producelocation) {
        this.name = name;
        this.price = price;
        this.producelocation = producelocation;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "fruits{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producelocation='" + producelocation + '\'' +
                '}';
    }
}
