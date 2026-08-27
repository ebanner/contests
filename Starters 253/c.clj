(defmacro reduce* [init coll f]
  `(reduce ~f ~init ~coll))

(def A 2)
(def B 1)
(def P 6)
(def Q 3)
(def R 4)

(def I B)
(def J A)

(def grid
  (let [I' (+ I 2)
        J' (+ J 2)]

    (->>
     (for [_ (range (inc I'))]
       (repeat (inc J') ##Inf))
     (mapv vec))))

(println)

(doseq [row grid]
  (println row))

(println)

(def grid' (assoc-in grid [0 0] 0))

(doseq [row grid']
  (println row))

(println)

(def i 0)
(def j 0)


(def *grid*
 (->
  grid'
  (assoc-in [i (+ j 1)] (min (get-in grid' [i (+ j 1)]) P))
  (assoc-in [i (+ j 2)] (min (get-in grid' [i (+ j 2)]) P))
  (assoc-in [(+ i 1) j] (min (get-in grid' [(+ i 1) j]) Q))
  (assoc-in [(+ i 2) j] (min (get-in grid' [(+ i 2) j]) Q))
  (assoc-in [(+ i 1) (+ j 1)] (min (get-in grid' [(+ i 1) (+ j 1)]) R))))

(doseq [row *grid*]
  (println row))

(for [i (range (inc I))]
  (println i))

(println)

(get-in grid' [i (+ j 1)])

(def *grid*
  (reduce* grid'
    (for [j (range (inc J)) i (range (inc I))] [i j])
    (fn [grid [i j]]
      (let [cost (get-in grid [i j])]
       (->
        grid
        (assoc-in [i (+ j 1)] (min (get-in grid [i (+ j 1)]) (+ cost P)))
        (assoc-in [i (+ j 2)] (min (get-in grid [i (+ j 2)]) (+ cost P)))
        (assoc-in [(+ i 1) j] (min (get-in grid [(+ i 1) j]) (+ cost Q)))
        (assoc-in [(+ i 2) j] (min (get-in grid [(+ i 2) j]) (+ cost Q)))
        (assoc-in [(+ i 1) (+ j 1)] (min (get-in grid [(+ i 1) (+ j 1)]) (+ cost R))))))))

(doseq [row *grid*]
  (println row))

*grid*

(println)

(def *grid*
  (reduce* grid'
    (for [j (range (inc J)) i (range (inc I))] [i j])
    (fn [grid [i j]]
      (let [cost (get-in grid [i j])]
       (->
        grid
        (assoc-in [(+ i 1) j] (min (get-in grid [(+ i 1) j]) (+ cost P)))
        (assoc-in [(+ i 2) j] (min (get-in grid [(+ i 2) j]) (+ cost P)))
        (assoc-in [i (+ j 1)] (min (get-in grid [i (+ j 1)]) (+ cost Q)))
        (assoc-in [i (+ j 2)] (min (get-in grid [i (+ j 2)]) (+ cost Q)))
        (assoc-in [(+ i 1) (+ j 1)] (min (get-in grid [(+ i 1) (+ j 1)]) (+ cost R))))))))

(doseq [row *grid*]
  (println row))
