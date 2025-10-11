(ns teoten.portfoliocljs.builder)

;; Simple post
(defn simple-post [id header body]
  "Simple pst with a header and body for the accordion."
  {:id id :title header :collapsed true
   :body (fn [] [:div.row
                 (for [paragraph body]
                   ^{:key paragraph} [:p paragraph])])})


;; Lists
(defn list-left-right []
  "A list with a `:header`, and a `:left` / `:right` side of text underneat."
  (fn [{:keys [header left right]}]
    (let [sepparator " | "]
      [:div {:class "list-left-right"}
       [:h5 header]
       [:p (str left sepparator right)]])))

(defn list-simple []
  (fn [{:keys [header elements]}]
    [:div {:class "list-simple"}
     [:h5 header]
     [:ul
      (for [el elements]
        ^{:key el} [:li el])]]))

(defn list-left-link []
  "A list with a `:header`, and a `:left` / `:right` (`link`) side of text underneat."
  (fn [{:keys [header left right link]}]
    (let [sepparator " · "]
      [:div {:class "list-left-link"}
       [:h5 header]
       [:p left sepparator [:a {:href link} right]]])))

(defn title-text-links []
  (fn [{:keys [header description l1 t1 l2 t2 l3 t3]}]
    [:div {:class "title-text-links"}
     [:h5 {:class "ttl"} header]
     [:p description]
     [:div {:class "row justify-content-center small-text-link"}
      (cond
        (and l1 t1 l2 t2 l3 t3) (list
                                 [:div.col-4 {:key l1} [:a {:href l1} t1]]
                                 [:div.col-4 {:key l2} [:a {:href l2} t2]]
                                 [:div.col-4 {:key l3} [:a {:href l3} t3]])
        (and l1 t1 l2 t2) (list
                           [:div.col-6 {:key l1} [:a {:href l1} t1]]
                           [:div.col-6 {:key l2} [:a {:href l2} t2]])
        (and l1 t1) (list [:div.col-12 {:key l1} [:a {:href l1} t1]])
        :else [:div {:class "tt-error"} [:h1"ERROR!: Provide pairs of link/text in content.cljs"]])]]))


(defn listing [f id header body-vector]
  "Create a list by applying `f` to `body-vector` which is a vector of
  maps with the keys needed for `f`. `id` and `header` are passed
  directly to the accordion."
  {:id id :title header :collapsed true
   :body (fn [] [:div
                 (for [li body-vector]
                   ^{:key li} [f li])])})


