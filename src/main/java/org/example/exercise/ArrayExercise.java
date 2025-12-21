package org.example.exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayExercise {

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        System.out.println("array:");
        arrayDemo();
        System.out.println("\nstring:");
        stringDemo();
        System.out.println("\nlist:");
        listDemo();
        System.out.println("\nset:");
        setDemo();
        System.out.println("\nmap:");
        mapDemo();
        System.out.println("\nsort:");
        sortDemo();
        System.out.println("\nstream:");
        streamDemo();
        System.out.println("\nheap:");
        heapDemo();
    }


    private static void arrayDemo() {
        System.out.println("1. 一维数组核心操作");
        int[] arr = {3, 1, 4, 1, 5, 9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("2. 二分查找（数组必须先排序）");
        int index = Arrays.binarySearch(arr, 1);
        System.out.println(index); // 预期：0

        System.out.println("3. 多维数组");
        int[][] arr2 = new int[3][];
        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];
        for (int[] ints : arr2) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println("4. 数组扩容（数组长度固定，手动实现动态扩容）");
        int[] newArry = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArry, 0, arr.length);
        System.out.println(Arrays.toString(newArry));

        System.out.println("5. 数组去重");
        arr = new int[]{3, 1, 4, 1, 5, 9};
        System.out.printf("before: %s\n", Arrays.toString(arr));
        Set<Integer> unique = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        for (int v : arr) {
            if (!unique.contains(v)) {
                unique.add(v);
                temp.add(v);
            }
        }
        int[] newArr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            newArr[i] = temp.get(i);
        }
        System.out.printf("after: %s\n", Arrays.toString(newArr));
    }

    private static void stringDemo() {
        System.out.println("1. 字符串 ↔ 字符数组（必考）");
        String s = "JavaCodeTest";
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
        chars[0] = 'j';
        String newS = new String(chars);
        System.out.println(newS);

        System.out.println("2. 字符串拆分为字符串数组");
        String str = "apple,banana,orange";
        String[] split = str.split(",");
        System.out.println(Arrays.toString(split));


        System.out.println("3. 字符串数组合并为一个字符串");
        String join = String.join(":", split);
        System.out.println(join);
    }

    private static void mapDemo() {
        System.out.println("1. 统计频次");
        int[] arr = {2, 7, 11, 15, 2, 7, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("2. 按次数降序排序（转List+Comparator）");
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("3. 双括号初始化（简化）");
        Map<Integer, String> map2 = new HashMap<Integer, String>(){{
            put(1, "apple");
            put(2, "banana");
        }};
        System.out.println(map2.getOrDefault(0, "null"));
        System.out.println(map2.getOrDefault(1, "null"));
        map2.remove(0);
        map2.remove(1);
        System.out.println(map2.containsKey(1)); // 判断包含：false

        map2.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("HashMap统计字符串 \"abacbdefab\" 中每个字符出现的次数");
        String s = "abacbdefab";
        Map<Character, Integer> map3 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map3.put(c, map3.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        System.out.println("TreeMap遍历：自定义Comparator");
        Map<Integer, String> treeMap2 = new TreeMap<>((a, b) -> b - a);
        treeMap2.put(3, "C");
        treeMap2.put(1, "A");
        treeMap2.put(2, "B");
        treeMap2.forEach((k, v) -> System.out.println(k + ":" + v));

        List<Map.Entry<Integer, String>> list2 = new LinkedList<>(treeMap2.entrySet());
        System.out.println("按照value升序, 需要先转为List");
        list2.sort(Map.Entry.comparingByValue());
        list2.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));


        int[] scores = {85, 90, 85, 80};
        System.out.println("记录“分数-原始下标”的映射");
        Map<Integer, List<Integer>> scoreToIndex = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            scoreToIndex.computeIfAbsent(scores[i], k->new ArrayList<>()).add(i);
        }
    }

    private static void listDemo() {
        System.out.println("1. ArrayList的基本操作");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.add(4);
        list.remove(2);
        list.set(1, -3);
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n2. LinkedList的基本操作");
        LinkedList<Character> ll = new LinkedList<>();
        ll.offer('a'); ll.offer('b'); ll.offer('c');
        System.out.println(ll);
        System.out.println("作为队列（FIFO）");
        Character cc = ll.poll();
        System.out.printf("poll() %s\n", cc);
        System.out.printf("peek() %s\n", ll.peek());
        System.out.println(ll);
        System.out.println("作为栈（FILO）");
        ll.push('d');ll.push('e');
        System.out.println(ll);
        cc = ll.pop();
        System.out.printf("pop() %s\n", cc);
        System.out.printf("peek() %s\n", ll.peek());
    }

    private static void setDemo() {
        System.out.println("HashSet: 空初始化+add");
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");
        set.add("orange");
        System.out.println(set);
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        System.out.println(set2);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);

        System.out.println("TreeSet的元素需要支持排序");
        System.out.println("对象实现Comparable的排序");
        Set<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student(2, "yak"));
        treeSet.add(new Student(1, "hxp"));
        treeSet.add(new Student(3, "zzk"));
        System.out.println(treeSet);


        System.out.println("自定义Comparator排序");
        Set<A> treeSet2 = new TreeSet<>(Comparator.comparing(e -> e.name));
        treeSet2.add(new A("x"));
        treeSet2.add(new A("abc"));
        treeSet2.add(new A("uvw"));
        treeSet2.add(new A("Zuvw"));
        System.out.println(treeSet2);
    }

    private static void sortDemo() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "yak"));
        students.add(new Student(1, "hxp"));
        students.add(new Student(3, "azk"));
        students.add(new Student(4, "yak"));
        Collections.sort(students);
        System.out.println("1. 自然排序（student的排序）");
        System.out.println(students);

        System.out.println("2. 自定义排序（name升序）");
        students.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println(students);
        System.out.println("3. 按name字典序，name相同按id降序");
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int v= o1.name.compareTo(o2.name);
                if (v!=0) return v;
                return o2.id-o1.id;
            }
        });
        System.out.println(students);


        int[] arr = new int[]{5, 2, 8, 2, 9, 1, 5};
        List<Integer> list = Arrays.stream(arr).distinct()
                .boxed()
                .sorted((s1, s2) -> s2 - s1)
                .collect(Collectors.toList());
        System.out.println(list);
        int[] sortedArray = Arrays.stream(arr).distinct().sorted().toArray();
        System.out.println(sortedArray[2]);
    }

    private static void streamDemo() {
        int[] arr = {1,3,5,7,9,2,4,6,8,10};
        System.out.println("反转[2,7]区间的数字");
        int i=2, j=7;
        while (i<=j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("收集偶数的索引");
        int[] indices = IntStream.range(0, arr.length).toArray();
        int[] even = Arrays.stream(indices).filter(id -> arr[id] % 2 == 0).toArray();
        System.out.println(Arrays.toString(even));
    }

    private static void heapDemo() {
        System.out.println("TOP 2 高频元素");
        int[] nums = new int[] {1,1,1,2,2,3};
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int v : nums) {
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (int k: freqMap.keySet()) {
            if (pq.size() < 2) {
                pq.offer(2);
            } else {
                if (freqMap.get(k) > freqMap.get(pq.peek())) {
                    pq.poll();
                    pq.offer(k);
                }
            }
        }
        System.out.println(pq.peek());
    }


}
class A {
    String name;
    public A(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Student implements Comparable<Student> {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
    @Override
    public String toString() {
        return "Student(" + id + "," + name + ")";
    }
}
