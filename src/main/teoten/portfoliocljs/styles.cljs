(ns teoten.portfoliocljs.styles
  (:require-macros [cljss.core])
  (:require
   [reagent.core :as r]
   [cljss.core :refer-macros [defstyles] :refer [inject-global]]
   [cljss.reagent :refer-macros [defstyled]]
   ))

;; Light/dark mode
(defonce dark-mode (r/atom false))

(defn toggle-col-mode []
  "Toggle the dark mode"
  (do
    (swap! dark-mode not)
    (-> js/document
        .-body
        .-classList
        (.toggle "dark"))))

;; Variables
(def css-fonts
  {:header "Helvetica Neue"
   :header-sub "Tahoma Sans Serif"
   :text "Courier Monospace"})

(def css-colors
  {:bg-main "#ffff"
   :d-bg-main "#2b6777"
   :bg-sub "#c8d8e8"
   :d-bg-sub "#52ab98"
   :txt-main "#2b6777"
   :d-txt-main "#ffff"
   :txt-sub "black"
   :txt-footer "#d5d5d5"
   :margins "#52ab98"
   })


;; Custom styles
(defstyles left-side [color]
  {:background-color color
   :padding "2rem"
   :border-radius "9px"
   :border-width "4px"
   :border-style "inset"
   :border-color color
   :margin "0.5rem"})

(defn render-left-side []
  (left-side 
   (if @dark-mode (css-colors :d-bg-sub) (css-colors :bg-sub))))

(defstyles theme-toggler [color]
  {:color color
   :font-size "1.3rem"})

(defstyles accordion-box []
  {:background-color "inherit"
   :cursor "pointer"
   :position "relative"
   :border-radius "0.75em"
   :border-style "double"
   :border-color (css-colors :margins)
   :&:hover {:opacity "1"
             :background "linear-gradient(45deg, transparent 5%,
    rgb(82, 143, 171) 50%, transparent 99% )" }
   })

(defstyles accordion-content []
  {:&:hover {:background-color (css-colors :bg-sub)}})


;; Main css styles
(inject-global
 {:body {:background-color (css-colors :bg-main)
         :color (css-colors :txt-main)}
  :body.dark {:background-color (css-colors :d-bg-main)
          :color (css-colors :d-txt-main)}
  :h1 {:font-family (css-fonts :header)
       :font-size "2rem"
       :font-weight 900}
  :h2 {:font-family (css-fonts :header)
       :font-size "1.8rem"
       :font-weight 500}
  :h3 {:font-family (css-fonts :header-sub)
       :font-size "1.6rem"
       :font-weight 500}
  :h4 {:font-family (css-fonts :header-sub)
       :font-size "1.2rem"
       :font-weight 400}
  :p {:font-size "1.2rem"
      :font-family (css-fonts :text)
      }
  :img {:height "auto"}
  :.flex-wrap {:flex-wrap "wrap !important"}
  :.flex-horizontal {:display "flex !important"}
  :.justify-center {:justify-content "center !important"}
  :i {:display "inline-block"
      :width "10%"
      :height "100%"
      :color "#f2f2f2"
      :flex-shrink 0}
  :.accordion-item {:padding "0.4rem"
                    :background-color "inherit"}
  :.accordion-box{:background-color "inherit"}
  :.accordion-header {:margin "0.4rem"
                      :background-color "inherit"
                      :cursor "pointer"}
  :.toggler {:cursor "pointer"}
  :.rounded-img {:border-radius "9999px !important"
                 :margin-bottom "20px"}
  :.footer {:position "relative"
            :padding "20px 50px"
            :display "flex"
            :justify-content "center"
            :flex-direction "column"}
  :.inner-footer {:color (css-colors :txt-footer)
                  :font-size "0.8rem"
                  :font-family (css-fonts :text)
                  :margin "15px 0 10px 0"
                  :font-weight 300}
  :.ttl {:padding-top "0.9rem"}
  })


