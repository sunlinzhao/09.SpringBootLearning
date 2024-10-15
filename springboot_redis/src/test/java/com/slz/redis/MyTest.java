package com.slz.redis;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/15
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
public class MyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt(); // 数组长度
        int k = scanner.nextInt(); // 操作次数
        int x = scanner.nextInt(); // 每次操作减去的数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.offer(scanner.nextInt()); // 将元素添加到最大堆中
        }

        // 调用方法计算结果并输出
        int result = minimizeMaxValue(maxHeap, k, x);
        System.out.println(result);
    }

    private static int minimizeMaxValue(PriorityQueue<Integer> maxHeap, int k, int x) {
        // 进行k次操作
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                break;
            }
            // 取出当前最大值
            int maxVal = maxHeap.poll();
            // 减去x
            maxVal -= x;
            // 将更新后的值放回堆中
            maxHeap.offer(maxVal);
        }

        // 返回堆顶元素，即为操作后的最大值
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

