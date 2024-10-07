(defn is-prime? [n]
      (cond
             (< n 2) false
             (= n 2) true
             (= (mod n 2) 0) false
             :else
             (let [limit (Math/sqrt n)]
                  (loop [i 3]
                        (if (> i limit)
                               true
                               (if (= (mod n i) 0)
                                      false
                                      (recur (+ i 2))))))))

(defn nth-prime [n]
      (let [prime-count (atom 0)
            current (atom 1)]
           (loop []
                 (swap! current inc)
                 (when (is-prime? @current)
                       (swap! prime-count inc))
                 (if (= @prime-count n)
                        @current
                        (recur)))))



(println (nth-prime 10001))
