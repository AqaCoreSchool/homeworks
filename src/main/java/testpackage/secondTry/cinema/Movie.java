package testpackage.secondTry.cinema;

    public enum Movie {

        JOKER ("Joker",
                "The origin tale of the Joker (Joaquin Phoenix) " +
                        "– one of the most iconic villains in comic book history.",
                "Thriller",
                new String[]{"16:00", "18:00", "22:00"},
                "English",
                "3D",
                16
                ),
        SHOPLIFTERS ("Shoplifters",
                "When Osamu Shibata finds five-year-old Yuri on the streets, " +
                        "cold and starving on a winter night, he brings her home to feed her.",
                "Drama",
                new String[]{"12:00", "15:00", "22:00"},
                "Ukraine",
                "5D",
                12),
        ROCKETMAN ("Rocketman",
                "An epic musical fantasy about the incredible " +
                        "story of Elton John's breakthrough years.",
                "Biography",
                new String[]{"13:00", "15:00", "21:00"},
                "English",
                "2D",
                16),
        SHAZAM ("Shazam",
                "We all have a superhero inside us," +
                        " it just takes a bit of magic to bring it out.",
                "Adventure",
                new String[]{"10:00", "13:00", "17:00"},
                "Ukraine",
                "2D",
                12),
        US ("Us",
                "A family's serene beach vacation turns to chaos " +
                        "when their doppelgängers appear and begin to terrorize them.",
                "Horror",
                new String[]{"09:00", "19:00", "21:00"},
                "English",
                "5D",
                18),
        MIDWAY ("Midway",
                "The story of the Battle of Midway, " +
                        "told by the leaders and the sailors who fought it.",
                "Action",
                new String[]{"11:00", "15:00", "23:00"},
                "Ukraine",
                "3D",
                16),
        PARASITE("Parasite",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy" +
                        " and glamorous Parks for their livelihood until" +
                        " they get entangled in an unexpected incident.",
                "Thriller",
                new String[]{"16:30", "18:45", "20:00"},
                "English",
                "2D",
                18),
        LIGHTHOUSE("Lighthouse",
                "From Robert Eggers, the visionary filmmaker behind modern horror masterpiece",
                "Horror",
                new String[]{"11:45", "14:15", "23:00"},
                "Spain",
                "3D",
                18),
        ABOMINABLE("Abominable",
                "When teenage Yi (Chloe Bennet, Marvels Agents of S.H.I.E.L.D.) " +
                        "encounters a young Yeti on the roof of her apartment building in Shanghai",
                "Animation",
                new String[]{"11:00", "15:30", "18:00"},
                "Ukraine",
                "3D",
                12),
        HUSTLERS("Hustlers",
                "Inspired by the viral New York Magazine article, Hustlers" +
                                   " follows a crew of savvy former strip club employees",
                "Drama",
                new String[]{"12:00", "16:15", "22:00"},
                "English",
                "5D",
                16),
        JUDY("Judy",
                "Winter 1968 and showbiz legend Judy Garland arrives in Swinging London to perform" +
                        " a five-week sold-out run at The Talk of the Town.",
                "Biography",
                new String[]{"11:00", "15:00", "23:00"},
                "Russia",
                "5D",
                16),
        TERMINATOR("Terminator",
                "Linda Hamilton (Sarah Connor) and Arnold Schwarzenegger" +
                        " (T-800) return in their iconic roles in Terminator",
                "Sci-Fi",
                new String[]{"10:45", "15:15", "19:00"},
                "English",
                "2D",
                16),
        MALEFICENT("Maleficent",
                "The years have been kind to Maleficent and Aurora. Their relationship," +
                        " born of heartbreak, revenge and ultimately love, has flourished.",
                "Fantasy",
                new String[]{"13:30", "17:00", "21:00"},
                "Ukraine",
                "3D",
                16),
        HARRIET("Harriet",
                "Based on the story of iconic freedom fighter Harriet Tubman, her escape from slavery",
                "Biography",
                new String[]{"10:00", "16:00", "18:30"},
                "Spain",
                "5D",
                16),
        COUNTDOWN("Countdown",
                "In COUNTDOWN, when a young nurse downloads an app that claims" +
                        " to predict exactly when a person is going to die, " +
                        "it tells her she only has three days to live.",
                "Horror",
                new String[]{"11:00", "15:00", "23:00"},
                "Russia",
                "5D",
                18);

        private String nameFilm;
        private String description ;
        private  String genre;
        private String[] session;
        private String voiceLanguage;
        private String format;
        private int ageLimit;

          Movie(String nameFilm, String description, String genre, String[] session,
                String voiceLanguage, String format, int ageLimit) {
              this.nameFilm = nameFilm;
              this.description = description;
              this.genre = genre;
              this.session = session;
              this.voiceLanguage = voiceLanguage;
              this.format = format;
              this.ageLimit = ageLimit;
        }

        public String getNameFilm() {
            return nameFilm;
        }

        public String getDescription() {
            return description;
        }

        public String getGenre() {
            return genre;
        }

        public String[] getSession() {
            return session;
        }

        public String getVoiceLanguage() {
            return voiceLanguage;
        }

        public String getFormat() {
            return format;
        }

        public int getAgeLimit() {
            return ageLimit;
        }
    }
