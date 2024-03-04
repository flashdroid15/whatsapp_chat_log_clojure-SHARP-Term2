(defn main [*command-line-args*] 
  (let [filepath (nth *command-line-args* 0)
        filepath2 (nth *command-line-args* 1)
        name (nth *command-line-args* 2 )
        chat_history (str/split-lines (slurp filepath))
        p (re-pattern (str \] \  name \: \| \ \- \ name \:))
        match? (fn [x] (re-find p x))
        notEqualsnil? (fn [x] (not= (match? x) nil))]
    (doseq [x (filter notEqualsnil? chat_history)]
           (spit filepath2 (str x "\n") :append true))
    ))

(main *command-line-args*)