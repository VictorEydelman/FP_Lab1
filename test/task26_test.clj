(ns test.task26-test
    (:require [clojure.test :refer [deftest testing are run-tests]]
      [task26 :refer [ex26 ex26_1_2 ex26_2 ex26_3 ex26_4 ex6_27]]))

(deftest test-ex26_1_1
         (testing (is (= (ex26) 983))))
(deftest test-ex26_1_2
         (testing (is (= (ex26_1_2) 983))))
(deftest test-ex26_2
         (testing (is (= (ex26_2) 983))))
(deftest test-ex26_3
         (testing (is (= (ex26_3) 983))))
(deftest test-ex26_4
         (testing (is (= (ex26_4) 983))))
(deftest test-ex26_5
         (testing (is (= (ex26_5) 983))))
(run-tests)
