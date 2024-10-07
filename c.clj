
(defn ch [kol num]
      (loop [i (int (Math/sqrt num))]
            (if (zero? (rem num i))
              (if (= i 1)
                (inc kol)
                kol)
              (recur (dec i)))))
(defn pr? [num]
      (loop [i (int (Math/sqrt num))]
            (if (zero? (rem num i))
              (= i 1)
              (recur (dec i)))))
(defn gen [] (for [i (range 1 1000)] i))
(defn prost []
      (->> (gen)
           (filter pr?)

           ))
(println (prost))
