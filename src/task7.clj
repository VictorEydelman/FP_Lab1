(ns task7)
(defn pr? [num]
      (loop [i (int (Math/sqrt num))]
            (if (zero? (rem num i))
              (= i 1)
              (recur (dec i)))))
(defn ex7 []
      (loop [num 1 kol 0]
            (if (<= kol 10001)
              (recur (inc num) (if (pr? num) (inc kol) kol))
              (dec num))))
(defn ex7_1_2
      ([] (ex7_1_2 3 1))
      ([num kol] (if (< kol 10001)
                   (if (pr? num)
                     (recur (inc num) (inc kol))
                     (recur (inc num) kol))
                   (dec num))))
(defn ex7_2 []
      (nth (filter pr? (for [i (range 1 (inc 1000000))] i)) 10001))
(defn ex7_3 []

      (nth (map + (filter pr? (range 1 (inc 1000000)))) 10001)
      )

(defn ex7_4 []
      (let [res (atom -1) kol 10001 i (atom 0)]
           (doseq [num (range 2 1000000)]
                  (when (pr? num)
                        (swap! i inc))
                  (when (and (pr? num) (= kol @i))
                        (reset! res num)
                        )) @res))
(defn ex7_5
      ([] (ex7_5 10001))
      ([n]
       (->> (for [i (range 2 (inc 1000000))] i)
            (filter pr?)
            (take n)
            (apply max))))
