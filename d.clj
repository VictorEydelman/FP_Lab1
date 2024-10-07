(defn pr? [num]
      (loop [i (int (Math/sqrt num))]
            (if (zero? (rem num i))
              (= i 1)
              (recur (dec i)))))

(defn prost3 []
      (let [kol (atom 11) rez (atom 0) i (atom 0)]
           (doseq [num (range 1 1000)]
                  (when (pr? num)
                        (do(swap! @i inc)
                         (when (= @kol @i)
                               (reset! rez num)))))@rez))
(println (prost3))