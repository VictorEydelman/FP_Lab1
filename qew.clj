(defn max-delta [a b]
      (reduce max (map #(Math/abs (- %1 %2)) a b)))
(println (max-delta
           (list )
           (list )))
