(defn pr? [num]
      (loop [i (int(Math/sqrt num))]
            (if (zero? (rem num i))
              (= i 1)
              (recur (dec i)))))

(defn prost []
      (loop [num 1 kol 0]
            (if (<= kol 10001)
               (recur (inc num) (if (pr? num) (inc kol) kol))
               (println (- num 1)))))
(prost)