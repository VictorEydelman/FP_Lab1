(ns test.task7_test
    (:require [clojure.test :refer [deftest testing is run-tests]]
      [task7 :refer [ex7 ex7_1_2 ex7_2 ex7_3 ex7_4 ex7_5]]))

(deftest test-ex7_1_1
         (testing (is (= (ex7) 104743))))
(deftest test-ex7_1_2
         (testing (is (= (ex7_1_2) 104743))))
(deftest test-ex7_2
         (testing (is (= (ex7_2) 104743))))
(deftest test-ex7_3
         (testing (is (= (ex7_3) 104743))))
(deftest test-ex7_4
         (testing (is (= (ex7_4) 104743))))
(deftest test-ex7_5
         (testing (is (= (ex7_5) 104743))))
(run-tests)
