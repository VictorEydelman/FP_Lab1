(defn pr? ([num l kol] (pr? num l (dec kol) kol))
      ([num l i kol]                                        ;(println num l kol i (nth l i) (> (nth l i) (int(Math/sqrt num))) (zero? (rem num (nth l i))))
       (if (> (nth l i) (int(Math/sqrt num)))
         true
         (if (zero? (rem num (nth l i)))
           false
           (pr? num l (dec i) kol)))
       )
      )
(defn prost
      ( [] (prost 3 1 '(2)))
      ([num kol l]
       ( if (< kol 485)
         (if (pr? num l kol)
           (prost (inc num) (inc kol) (conj l num))
           (prost (inc num) kol l))
         (println (- num 1)))))

(prost)