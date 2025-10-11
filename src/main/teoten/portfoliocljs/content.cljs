(ns teoten.portfoliocljs.content
  (:require
   [teoten.portfoliocljs.builder :as build]))

;; General
(def person "Manuel Teodoro Tenango")

(def position "R developer")

(def location "Gdansk, PL")

(def contact "teoten [at] teoten [dot] me")

(def img "Bwyo.png")

(def socials [{:link "https://www.linkedin.com/in/teoten/"
               :icon "fa-linkedin-in"}
              {:link "https://codeberg.org/teoten"
               :icon "fa-github"}
              {:link "https://social.linux.pizza/@teoten"
               :icon "fa-mastodon"}])

;; Accordion content
(def about "Description"
  ["My story with programming begins back in my studies of Master in
  2012 when I learned basic C and statistics with R. Also around that
  time I started using Linux and tested several distros since then,
  which gave me a wide understanding of Shell, Bash and Linux in
  general."
   
   "During my Ph.D. I started using R more professionally for data
   analysis projects: statistics, data scrapping, wrangling,
   visualizations, dashboards and programming in general. Also I
   started using Shiny for personal projects."

   "My experience with R comes from my Ph.D. work and positions as
   Statistician and Software Engineer in the pharmaceutical
   industry. I have worked in projects for Data Analysis, Statistics,
   R Packages and Software Engineering. My experience with Shiny is
   mainly with the creation of Dashboards and Apps for NGOs, some of
   which I've been allowed to make public under certain restrictions."

   "Working with R Shiny helped me discover my passion for building
   web apps, which took me to the path of learning JavaScript, HTML
   and CSS. The wish to deploy my own apps and apps for an NGO with
   minimal IT infrastructure forced me to learn about Linux servers,
   Nginx and Docker, among others."

   "Being an Emacs user since my Ph.D. studies developed my love for
   the Lisp family of languages. It was also back then when Common
   Lisp gave me strong basis for Functional Programming. In 2024 I
   started learning Clojure and Clojure-script to expand my knowledge
   in Full Stack development and overcome some of the limitations of
   Shiny apps."])

(def projects [{:header "Mapic"
                :description "R Package for the creation of Maps of Infrastructure per City (MAPIC). The app is used in production by an NGO."
                :l1 "https://codeberg.org/teoten/mapic" :t1 "Code"
                :l2 "https://dev.teoten.com/shiny/shinyMapic/" :t2 "Shiny App"
                :l3 "https://codeberg.org/teoten/shinyMapic" :t3 "Shiny Code"
                }
               {:header "Biodiversity in PL"
                :description "Toy shiny app to explore biodiversity in Poland."
                :l1 "https://codeberg.org/teoten/MTTbiodiversity" :t1 "Code"
                :l2 "https://dev.teoten.com/shiny/MTTbiodiversity/" :t2 "Shiny App"
                }
               {:header "Hepatitis C"
                :description "Flex dashboard for the dataset of Hepatitis C."
                :l1 "https://codeberg.org/teoten/hepatitis_dashboard" :t1 "Code"
                :l2 "https://dev.teoten.com/shiny/hepatitis_dashboard/" :t2 "App"}
               {:header "Personal Finances"
                :description "Toy Shiny app created with Golem for calculation of savings."
                :l1 "https://codeberg.org/teoten/PersonalFinances" :t1 "Code"
                :l2 "https://dev.teoten.com/shiny/PersonalFinances/" :t2 "App"}
               {:header "Personal Blog"
                :description "My personal blog is written in pure Clojure with no frameworks. I have crafted the code that builds a static site using libraries like stasis and selmer. Also the CSS and JS code is mine with no frameworks. The blog is responsive and it shows my own style."
                :l1 "https://github.com/teotenn/blog.teoten.com" :t1 "Code"
                :l2 "https://blog.teoten.com/" :t2 "Site"}
               {:header "Resume / Portfolio"
                :description "My personal resume page with my portfolio (this very page) is written in Clojurescript."
                :l1 "https://codeberg.org/teoten/portfoliocljs" :t1 "Code"
                :l2 "https://resume.teoten.com/" :t2 "Site"}
               {:header "Database of News"
                :description "UI for storing, browsing and organizing news using jam.py. Backend in Python, fronten in Java Script."
                :l1 "#" :t1 "Private | No link"
                }])

(def experience [{:header "R Developer"
                  :left "2022-Present"
                  :right "Sii Poland"
                  :link "https://sii.pl/"
                  }
                 {:header "Statistician"
                  :left "2020-2022"
                  :right "Polpharma Biologics"
                  :link "https://polpharma.pl/"
                  }
                 {:header "Researcher (Ph.D. Cadidate)"
                  :left "2016-2020"
                  :right "Czech University of Life Sciences"
                  :link "https://www.fzp.czu.cz/cs"}])

(def education [{:header "M.S. in Biostatistics and Bioinformatics"
                 :left "2022-2024"
                 :right "Centre for European Master's Programme"
                 }
                {:header "Ph.D. in Environmental Sciences"
                 :left "2016-2020"
                 :right "Czech University of LifeSciences, Prague"
                 }
                {:header "M.S. in Environmental Sciences"
                 :left "2012-2014"
                 :right "Instituto Politecnico Nacional"
                 }
                {:header "B.Eng. in Ecological Restoration"
                 :left "2004-2008"
                 :right "Universidad Autonoma Chapingo"}])

(def pub-main [{:header "August 2020"
                :left "Nanoscale Zero-Valent Iron Has Minimum Toxicological Risk on the Germination and Early Growth of Two Grass Species with Potential for Phytostabilization"
                :right "Nanomaterials"
                :link "https://www.mdpi.com/2079-4991/10/8/1537"
                }
               {:header "February 2020"
                :left "Seasonal fluctuations of Zn, Pb, As and Cd contents in the biomass of selected grass species growing on contaminated soils: implications for in situ phytostabilization"
                :right "Science of the Total Environment"
                :link "https://www.sciencedirect.com/science/article/abs/pii/S0048969719347011"
                }
               {:header "March 2020"
                :left "Application of co-composted biochar significantly improved plant-growth relevant physical/chemical properties of a metal contaminated soil"
                :right "Chemosphere"
                :link "https://www.sciencedirect.com/science/article/abs/pii/S0045653519324956"}])

(def pub-co [{:header "2020. A. Latini et. al."
              :left "The Impact of Soil-Applied Biochars From Different Vegetal Feedstocks on Durum Wheat Plant Performance and Rhizospheric Bacterial Microbiota in Low Metal-Contaminated Soil"
                :right "Frontiers Microbiol"
                :link "https://www.frontiersin.org/journals/microbiology/articles/10.3389/fmicb.2019.02694/full"
                }
               {:header "2019. S. Wu et. al."
                :left "Nano zero-valent iron aging interacts with the soil microbial community: a microcosm study"
                :right "Environmental Science"
                :link "https://pubs.rsc.org/en/content/articlelanding/2019/en/c8en01328d#!divAbstract"
                }
               {:header "2018. S. Wu et. al"
                :left "Nano zero-valent iron mediated metal(oid) uptake and translocation by Arbuscular Mycorrhizal symbioses"
                :right "Environmental Science and Technology"
                :link "https://pubs.acs.org/doi/10.1021/acs.est.7b05516"}])


(def languages [{:header ""
                 :left "Spanish"
                 :right "Native"
                 }
                {:header ""
                 :left "English"
                 :right "C2"
                 }
                {:header ""
                 :left "Polish"
                 :right "B2"
                 }])

(def skills [{:header "" :elements ["R"
                                  "SQL"
                                  "Clojure(script)"
                                  "Python"
                                  "Common Lisp"
                                  "Bash"
                                  "Git"
                                  "Linux"
                                  "Nginx"
                                  "HTML"
                                    "CSS"]}])

(def hobbies [{:header "" :elements ["Qi-Gong"
                                     "Swimming"
                                     "Bonsai"
                                     "Litterature"]}])

;; Build accordion content
(def accordion-content (sorted-map
                        1 (build/simple-post 1 "About Me" about)
                        2 (build/listing build/title-text-links 2 "Projects" projects)
                        3 (build/listing build/list-left-link 3 "Profesional Experience" experience)
                        4 (build/listing build/list-left-right 4 "Education" education)
                        5 (build/listing build/list-left-link 5 "Publications (main author)" pub-main)
                        6 (build/listing build/list-left-link 6 "Publications (co-author)" pub-co)
                        7 (build/listing build/list-left-right 7 "Languages" languages)
                        8 (build/listing build/list-simple 8 "Technical Skills" skills)
                        9 (build/listing build/list-simple 9 "Hobbies" hobbies)
                        ))
