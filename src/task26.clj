(ns task26)
(defn index ([l arg] (index l arg 0))
      ([l arg i] (if (= arg (nth l i)) i (index l arg (inc i)))))
(defn cou
      ([i] (cou 1 i '()))
      ([n i l]
       (if (< n i)
         (cou (* 10 n) i l)
         (if (some #{(rem n i)} l)
           (inc (index l (rem n i)))
           (if (zero? (rem n i)) 1 (cou (rem n i) i (conj l (rem n i))))))))

(defn ex26 []
      (loop [i 1000 max 0 num 0]
            (if (> i 0)
              (recur (dec i) (if (> (cou i) max) (cou i) max) (if (> (cou i) max) i num))
              num)))

(defn ex26_1_2
      ([] (ex26_1_2 1000 0 0))
      ([i max num]
       (if (> i 0)
         (ex26_1_2 (dec i) (if (> (cou i) max) (cou i) max) (if (> (cou i) max) i num))
         num)))

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
                    ( (reset! max (cou i)) (reset! num i)))
        )@num))

(defn infinite-sequence []
  (iterate inc 1))

(defn ex26_5 []
      (let [i (map cou (take 1000 (infinite-sequence)))]
            (inc (index i (reduce max i)))))

