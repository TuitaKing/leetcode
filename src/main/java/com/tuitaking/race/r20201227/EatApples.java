package com.tuitaking.race.r20201227;


import java.util.PriorityQueue;

/**
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，
 * 这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。
 * 也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 * 示例 1：
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 *
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * 提示：
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 */
public class EatApples {

    public  int eatenApples(int[] apples, int[] days) {
        int max=0;
        for(int i = 0 ; i < apples.length;i++){
            int tmp=Math.min(apples[i],days[i]);
            if(tmp+i>max){
                max+=tmp;
            }
        }
        return max;
    }


    // 优先队列，保存过期时间和苹果数。队头是最早过期的苹果
    public  int eatenApples_v1(int[] apples, int[] days){
        // 按照过期时间
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>((o1,o2)->o1[1]<o2[1]?-1:1);
        int eatNum=0;
        // 这里的i 表示的其实是能吃的苹果的时间,所有的天数，包括了不能吃苹果的天数。
        for(int i = 0 ; i <apples.length || !queue.isEmpty();i++){
            // 如果现在有苹果在队列中，移除已经过期的，注意这里是<=
            while (!queue.isEmpty()){
                int[] apple=queue.peek();
                if(apple[1]<=i){ //?
                    queue.poll();
                }else {
                    break;
                }
            }
            // 由于循环是两个，所以需要添加判断
           if(i<apples.length&&apples[i]>0){
               queue.offer(new int[]{apples[i],days[i]+i});
           }
           // 吃掉最早过期的苹果
           int[] curr=queue.peek();
           // 如果当前有苹果可以吃，而且当前可以吃的苹果数不是0，则吃掉一个苹果
           if(curr!=null && curr[0]!=0){
               eatNum++;
               // 吃掉当前
               curr[0]-=1;
               //吃完则推出
               if(curr[0]==0){
                   queue.poll();
               }
           }
        }
        return eatNum;
    }
}
