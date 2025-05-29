package Algorithm.Sort;
import java.util.Arrays;
/**
 * @author shkstart
 * @create 2023-05-10 10:56
 */
public class HeapSort {
    public static void main(String[] args) {
        Heap HP = new Heap(10);
        insert(HP, 10);
        insert(HP, 9);
        insert(HP, 8);
        insert(HP, 7);
        insert(HP, 6);
        insert(HP, 5);
        insert(HP, 4);
        insert(HP, 3);
        insert(HP, 2);
        insert(HP, 1);
        sort(HP);
        System.out.println(Arrays.toString(HP.array));
    }

    static void insert(Heap HP, int key) {
        if (HP.tos < HP.num - 1) {
            HP.array[++HP.tos] = key;
            int p = HP.tos, tempt = HP.array[p];
            while (tempt < HP.array[p / 2]) {
                HP.array[p] = HP.array[p / 2];
                p /= 2;
            }
            HP.array[p] = tempt;
        } else {
            System.out.println("No room!");
        }
    }

    static void sort(Heap HP) {
        for (int k = 0; k < 9; k++) {
            int mini = HP.array[1];
                int last = HP.array[HP.tos];
                int p = 1;
                HP.tos--;

                while (p * 2 <= HP.tos) {
                    int child = p * 2;
                    if (HP.array[child] > HP.array[child + 1]) {
                        child++;
                    }
                    if (last > HP.array[child]) {
                        HP.array[p] = HP.array[child];
                    } else {
                        break;
                    }
                    p = child;
                }
                HP.array[p] = last;
            HP.array[HP.tos + 1] = mini;
        }
    }

    static void print(int[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.println(i + ":" + a[i]);
        }
    }
}

class Heap {
    int num;
    int tos = 0;
    int[] array;

    public Heap(int num) {
        this.num = num + 1;
        array = new int[this.num];
        array[0] = -10000;
    }
}