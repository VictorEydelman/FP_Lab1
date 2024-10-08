### Лабораторная работа №1

Выполнил: Эйдельман Виктор Аркадьевич</br>
Вариант: 7,26

## Условие проблем Эйлера:

Проблема Эйлера №7:</br>
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10001st prime number?

Проблема Эйлера №26:</br>
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
1/2 = 0.5</br>
1/3 = 0.(3)</br>
1/4 = 0.25</br>
1/5 = 0.2</br>
1/6 = 0.1(6)</br>
1/7 = 0.(142857)</br>
1/8 = 0.125</br>
1/9 = 0.(1)</br>
1/10 = 0.1</br>
Where 0.1(6) means 0.166666, and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

## Решение:
# Проблема №7:
```
(defn pr? [num]
      (loop [i (int (Math/sqrt num))]
            (if (zero? (rem num i))
              (= i 1)
              (recur (dec i)))))
```
Для проверки простое ли число проверяем, что число не делится на числа от 2 до корня данного числа.

1) монолитные реализации с использованием:

1.1)хвостовой рекурсии:
```
(defn ex7 []
      (loop [num 1 kol 0]
            (if (<= kol 10001)
              (recur (inc num) (if (pr? num) (inc kol) kol))
              (dec num))))
```
Для решения с помощью хвостовой рекурсии используем loop, и будем его рекурсивно вызывать пока с следующим проверяемым числом, пока количество простых чисел <=10001

1.2)рекурсии:
```
(defn ex7_1_2
      ([] (ex7_1_2 3 1))
      ([num kol] (if (< kol 10001)
                   (if (pr? num)
                     (recur (inc num) (inc kol))
                     (recur (inc num) kol))
                   (dec num))))
```
Для решения с помощью рекурсии используем похожий код как и в хвостовой рекурсии, с изменением начального вызова функции.

2)модульной реализации, где явно разделена генерация последовательности, фильтрация и свёртка:
```
(defn ex7_2 []
      (nth (filter pr? (for [i (range 1 (inc 1000000))] i)) 10001))
```
Для решения с помощью for генирируем последовательность, с помощью filter выбираем фильтруем последовательность на простые числа и с помощью nth выводим 10001 число

3)генерация последовательности при помощи отображения (map):
```
(defn ex7_3 []
      (nth (map + (filter pr? (range 1 (inc 1000000)))) 10001))
```
Для решения используется map для генирирации последовательности, отфильтрованной на простое число.

4)работа со спец. синтаксисом для циклов:
```
(defn ex7_4 []
      (let [res (atom -1) kol 10001 i (atom 0)]
           (doseq [num (range 2 1000000)]
                  (when (pr? num)
                        (swap! i inc))
                  (when (and (pr? num) (= kol @i))
                        (reset! res num)
                        )) @res))
```
Для решения используются doseq и atom-ы с swap! и reset!

5)работа с бесконечными списками для языков, поддерживающих ленивые коллекции или итераторы как часть языка:
```
(defn ex7_5
      ([] (ex7_5 10001))
      ([n]
       (->> (for [i (range 2 (inc 1000000))] i)
            (filter pr?)
            (take n)
            (apply max))))
```
Для решения генирируется большая последовательность, она фильтруется на простое число и берётся первые 10001 и берётся максимальное


# Проблема №26
```
(defn index ([l arg] (index l arg 0))
      ([l arg i] (if (= arg (nth l i)) i (index l arg (inc i)))))
```
Функция для определения индекса в list пренадлежащего элементу
```
(defn cou
      ([i] (cou 1 i '()))
      ([n i l]
       (if (< n i)
         (cou (* 10 n) i l)
         (if (some #{(rem n i)} l)
           (inc (index l (rem n i)))
           (if (zero? (rem n i)) 1 (cou (rem n i) i (conj l (rem n i))))))))
```
Функция возвращающая длин цикла в дробе 1/d

1) монолитные реализации с использованием:

1.1)хвостовой рекурсии:
```
(defn ex26 []
      (loop [i 1000 max 0 num 0]
            (if (> i 0)
              (recur (dec i) (if (> (cou i) max) (cou i) max) (if (> (cou i) max) i num))
              num)))
```
Для решения используется loop и рекурсивно он работает, пока не пройдёт все 1000 чисел, передавая дикремент предыдущего значения и максимум между длиной последнего значения и максимального, и номер выбранного

1.2)рекурсии:
```
(defn ex26_1_2
      ([] (ex26_1_2 1000 0 0))
      ([i max num]
       (if (> i 0)
         (ex26_1_2 (dec i) (if (> (cou i) max) (cou i) max) (if (> (cou i) max) i num))
         num)))
```
Для решения используется 
```
(defn generate []
      (for [d (range 1 1000)] (cou d)))
(defn maxim []
   (->> (generate) (reduce max)))
(defn ex26_2 []
      (inc (index (generate) (maxim))))

(defn generate3 []
      (map cou (range 1 (inc 1000))))
(defn maxim3 []
      (->> (generate3) (apply max)))
(defn ex26_3 []
      (inc (index (generate3) (maxim3))))

(defn ex26_4 []
      (let [max (atom 0) num (atom 0)] (doseq [i (range 1 1000)]
              (when (> (cou i) @max)
                    (do (reset! max (cou i)) (reset! num i)))
        )@num))

(defn infinite-sequence []
  (iterate inc 1))

(defn ex26_5 []
      (loop [i (map cou (take 1000 (infinite-sequence)))]
            (inc (index i (reduce max i)))))
```
