(defmacro reduce* [init coll f]
  `(reduce ~f ~init ~coll))


(defn get-grid [I J]
  (let [[I' J'] [(+ I 2) (+ J 2)]]
    (->
     (for [_ (range (inc I'))]
       (repeat (inc J') ##Inf))
     (->> (mapv vec))
     (assoc-in [0 0] 0))))


(defn -main [A B P Q R]
  (let [[I J] [B A]]
    (->
     (reduce*
      (get-grid I J) (for [j (range (inc J)) i (range (inc I))] [i j])
      (fn [grid [i j]]
        (let [cost (get-in grid [i j])]
          (->
           grid
           (assoc-in [i (+ j 1)] (min (get-in grid [i (+ j 1)]) (+ cost P)))
           (assoc-in [i (+ j 2)] (min (get-in grid [i (+ j 2)]) (+ cost P)))
           (assoc-in [(+ i 1) j] (min (get-in grid [(+ i 1) j]) (+ cost Q)))
           (assoc-in [(+ i 2) j] (min (get-in grid [(+ i 2) j]) (+ cost Q)))
           (assoc-in [(+ i 1) (+ j 1)] (min (get-in grid [(+ i 1) (+ j 1)]) (+ cost R)))))))

     (get-in [I J]))))

;; (-main 2 1 6 3 4)
