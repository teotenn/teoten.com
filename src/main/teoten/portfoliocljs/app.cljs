(ns teoten.portfoliocljs.app
  (:require
   [reagent.core :as r]
   [reagent.dom  :as dom]
   [teoten.portfoliocljs.styles :as sty]
   [teoten.portfoliocljs.content :as cont]
   [teoten.portfoliocljs.builder :as builder]
   ))


;; -------------------- From YAML file --------------------
;; Title/body elements
(defonce cards (r/atom cont/accordion-content))
(defonce socials (r/atom cont/socials))
;; -------------------- END --------------------

;; Supportive functions
(defn toggle-post [id] (swap! cards update-in [id :collapsed] not))


;; Accordion
(defn accordion-element []
  (fn [{:keys [id title body collapsed]}]
    [:div {:class (str "accordion-item " (sty/accordion-content))}
     [:div {:class (sty/accordion-box)}
      [:h2 {:class "accordion-header"
            :on-click #(toggle-post id)}
       title]]
      [:div {:class [(if collapsed "accordion-collapse collapse"
                         "accordion-collapse collapse show")]}
       [:div {:class "accordion-body"}
        [body]]]])) 

(defn accordion []
  (let [items (vals @cards)]
    [:div {:class "accordion" :id "main-accordion"}
     (for [post items]
       ^{:key (:id post)} [accordion-element post])]))


;; Socials
(defn list-socials []
  (fn [{:keys [link icon]}]
    [:div {:class "mx-2"}
     [:a {:href link}
      [:i {:class (str "mt-1 fab " icon)}]]]))

(defn listing-socials []
  (let [items  @socials]
    [:div {:class "flex-horizontal flex-wrap justify-center"}
     (for [i items]
       ^{:key i} [list-socials i])]))


;; Views
(defn view-main-img []
  [:div {:class "flex justify-center"}
   [:img {:class "rounded-img"
          :src "/img/Bwyo.png"
          :alt cont/person
          :style {:max-width "250px"}}]])

(defn view-titles []
  [:div {:class "text-center"}
    [:h1 cont/person]
    [:h2 cont/position]
    [:h3 cont/location]
   [:h4 cont/contact]])


(defn view-static []
  "Static view positioned on the right side of the screen. Intended to show personal info."
  [:div {:class "d-flex justify-content-center"}
   [:div {:class (sty/render-left-side)}
    [view-main-img]
    [view-titles]
    [listing-socials]]
   ])

(defn view-dynamic []
  "Dynamic view positoined on the left side of the screen. Intended to show the different sections."
  [:div {:class "d-flex justify-content-center"}
   (accordion)
   ])

(defn view-footer []
  [:footer {:class "footer"}
   [:div {:class "container row justify-content-center inner-footer"}
    "teoten 2024 | Powered by clojurescript"]])

(defn overview []
  [:main {:class "grow"}
   [:div {:class "container"}
    [:div {:class "row justify-content-center no-bar"}
     [:div {:class "col-10"}]
     [:div {:class "col-2"}
      [:p {:class "toggler" :on-click sty/toggle-col-mode}
       [:i {:class (if @sty/dark-mode
                     (str "fas fa-sun" " " (sty/theme-toggler "#ff5200"))
                     (str "fas fa-moon" " " (sty/theme-toggler "#b7b7b7")))}]]]]
    [:div {:class "row justify-content-center"}
     ;; Starts the centered content
     [:div {:class "col col-lg-3"}
      [view-static]]
     [:div {:class "col col-lg-5"}
      [view-dynamic]]]
    [view-footer]]])

;; Main functions to be called by the compiler
(defn Application []
  [overview])

(dom/render [Application] (.-body js/document))


(defn init []
  (Application))
