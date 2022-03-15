import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class start {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        String[] colors = {"🔶","🧡","♠","♣"};
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String color:colors) { // 遍历存牌
            for (String number: numbers) {
//                把花色和扑克牌连在一起，拼接字符串
                String poker = color + number;
                array.add(poker);
            }
        }
//        存入小王
        array.add("smalljoker");
//        存入大王
        array.add("JOKER");
        System.out.println("打印完整的一副牌：");
        System.out.println(array);
        ArrayList<String> player1 = new ArrayList<>();	// 玩家1
        ArrayList<String> player2 = new ArrayList<>();	// 玩家2
        ArrayList<String> player3 = new ArrayList<>();	// 玩家3
        //三张底牌
        ArrayList<String> underPokes = new ArrayList<>();
//       随机打乱原来的顺序， 洗牌
        Collections.shuffle(array);
        System.out.println("洗牌后打印：");
        System.out.println(array);

//        发牌
        for (int i = 0; i < array.size(); i++ ){
            String poke = array.get(i);
            if( i >= array.size()-3 ){  // 最后三张为底牌（如果索引大于总牌数 - 3 ，则说明已经到了底牌处，需要把牌放入底牌数组）
                underPokes.add(poke);
            }else if( i%3 == 0){    // i%3 ，因为有三个玩家，所以对三求余，实现一人一张的发牌方法
                player1.add(poke);
            }else if( i%3 == 1){
                player2.add(poke);
            }else {
                player3.add(poke);
            }
        }
        printPoke("player1",player1);	// 看牌
        printPoke("player2",player2);
        printPoke("player3",player3);
        printPoke("underPokes",underPokes);
    }
    public static void printPoke(String name,ArrayList<String> arrayList){	// 看牌功能
        System.out.print(name + "的牌是：");
        for (int i = 0; i < arrayList.size(); i++) {
            if( i == arrayList.size()-1 ) {

                System.out.print(arrayList.get(i));
            }else{
                System.out.print(arrayList.get(i) + ",");
            }
        }
        System.out.println("共"+arrayList.size()+"张牌");
    }

}
