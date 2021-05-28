package com.timotiushaniel.bajp3.utils

import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.data.source.model.FilmResult
import com.timotiushaniel.bajp3.data.source.model.Genre
import com.timotiushaniel.bajp3.data.source.remote.response.DetailFilmResponse

object DataDummy {

    // Local
    fun getMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                10,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                7.5,
                false,
                "Drama, Romance, Music",
                "2018-mm-dd",
                "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg"
            )
        )
        movies.add(
            MovieEntity(
                11,
                "Alita: Battle Angle",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                false,
                "Action, Science Fiction, Adventure",
                "2019-mm-dd",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"

            )
        )
        movies.add(
            MovieEntity(
                12,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                6.9,
                false,
                "Action, Adventure, Fantasy",
                "2018-mm-dd",
                "/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg"
            )
        )
        movies.add(
            MovieEntity(
                13,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0,
                false,
                "Music, Drama, History",
                "2019-mm-dd",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "/9441r6izIG2t46C2W1XoKYVN1o.jpg"
            )
        )
        movies.add(
            MovieEntity(
                14,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                5.7,
                false,
                "Action, Crime, Thriller",
                "2019-mm-dd",
                "/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "/irj3J9YwaMboICVU5gNmvXEAgkS.jpg"
            )
        )
        movies.add(
            MovieEntity(
                15,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                6.9,
                false,
                "Drama",
                "2019-mm-dd",
                "/zAu6ajsuyL9dwMhOFerfwqtjsX4.jpg",
                "/9il7qNbeYnPMYlutsVYDsj4hRyb.jpg"
            )
        )
        movies.add(
            MovieEntity(
                16,
                "Fantastic Beast: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                6.9,
                false,
                "Advanture, Fantasy, Drama",
                "2018-mm-dd",
                "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "/qrtRKRzoNkf5vemO9tJ2Y4DrHxQ.jpg"
            )
        )
        movies.add(
            MovieEntity(
                17,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                6.7,
                false,
                "Thriller, Drama, Science Fiction",
                "2019-mm-dd",
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )
        movies.add(
            MovieEntity(
                18,
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                7.8,
                false,
                "Fantasy, Adventure, Animation, Family",
                "2010-mm-dd",
                "/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "/kxklJL1v8MYEU5xdU6W5VvmBwVz.jpg"
            )
        )
        movies.add(
            MovieEntity(
                19,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                8.3,
                false,
                "Adventure, Action, Science Fiction",
                "2018-mm-dd",
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg"
            )
        )
        return movies
    }

    fun getMoviesDetail(): MovieEntity {
        return MovieEntity(
            10,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            7.5,
            false,
            "Drama, Romance, Music",
            "2018-mm-dd",
            "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg"
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                20,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                6.6,
                false,
                "Crime, Drama, Mystery, Action & Adventure",
                "2012-mm-dd",
                "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "/fFT7T9y9NVRdcdVh81roVrJBcDh.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                21,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.6,
                false,
                "Sci-Fi & Fantasy, Comedy, Drama",
                "2019-mm-dd",
                "/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg",
                "/b7unxzWSFfj7i6UVmuPixxxXFOF.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                22,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                8.1,
                false,
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "1986-mm-dd",
                "/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                "/jipCnOL1aH81wL6CdlrbvHpkueg.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                23,
                "Naruto Shipudden",
                "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans. This time Naruto's mission is to guard Shion, but she predicts Naruto's death. The only way to escape it, is to get away from Shion, which would leave her unguarded, then the demon, whose only goal is to kill Shion will do so, thus meaning the end of the world.",
                7.1,
                false,
                "Family, Action, Animation, Adventure, Fantasy",
                "2007-mm-dd",
                "/n9tyom1Y1vYOMrOGK0jYO3tkby.jpg",
                "/z6ES1hCbLozoquj5wilidrtKBPp.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                24,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                7.0,
                false,
                "Animation, Comedy",
                "1999-mm-dd",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "/jbTqU6BJMufoMnPSlO4ThrcXs3Y.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                25,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent.",
                7.7,
                false,
                "Drama, Sci-Fi & Fantasy",
                "2014-mm-dd",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "/bSKlSvNK0CKQ65X0A82smWUBqRO.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                26,
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                7.8,
                false,
                "Family, Animation, Comedy",
                "1989-mm-dd",
                "/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg",
                "/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                27,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2,
                false,
                "Drama",
                "2005-mm-dd",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/3IIBf6VlwEyKAX4cN2XCM1gKdgM.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                28,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                7.5,
                false,
                "Drama, Crime, Sci-Fi & Fantasy",
                "2014-mm-dd",
                "/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg",
                "/7QSM3AsgWXctWBm7OFov9dGdZgt.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                29,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                7.4,
                false,
                "Animation, Comedy, Family, Drama",
                "2003-mm-dd",
                "/eoj15m14Zpf2bUWXqNIs7itZK9w.jpg",
                "/wsU1R48t2V3cjsbHTj68JoDEo8G.jpg"
            )
        )
        return tvShows
    }

    fun getTvShowsDetail(): TvShowEntity {
        return TvShowEntity(
            20,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            6.6,
            false,
            "Crime, Drama, Mystery, Action & Adventure",
            "2012-mm-dd",
            "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "/fFT7T9y9NVRdcdVh81roVrJBcDh.jpg"
        )
    }

    // Remote
    fun getRemoteMovies(): List<FilmResult> {
        val remoteMovies = ArrayList<FilmResult>()

        remoteMovies.add(
            FilmResult(
                10,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                listOf(18, 10749, 10402),
                "2018-mm-dd",
                7.5,
                "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                11,
                "Alita: Battle Angle",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                listOf(28, 878, 12),
                "2019-mm-dd",
                7.2,
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                12,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                listOf(28, 12, 14),
                "2018-mm-dd",
                6.9,
                "/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                13,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                listOf(10402, 18, 36),
                "2019-mm-dd",
                8.0,
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "/9441r6izIG2t46C2W1XoKYVN1o.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                14,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                listOf(28, 80, 53),
                "2019-mm-dd",
                5.7,
                "/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "/irj3J9YwaMboICVU5gNmvXEAgkS.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                15,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                listOf(18),
                "2019-mm-dd",
                6.9,
                "/zAu6ajsuyL9dwMhOFerfwqtjsX4.jpg",
                "/9il7qNbeYnPMYlutsVYDsj4hRyb.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                16,
                "Fantastic Beast: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                listOf(12, 14, 18),
                "2018-mm-dd",
                6.9,
                "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "/qrtRKRzoNkf5vemO9tJ2Y4DrHxQ.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                17,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                listOf(53, 18, 878),
                "2019-mm-dd",
                6.7,
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                18,
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                listOf(14, 12, 16, 10751),
                "2010-mm-dd",
                7.8,
                "/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "/kxklJL1v8MYEU5xdU6W5VvmBwVz.jpg"
            )
        )
        remoteMovies.add(
            FilmResult(
                19,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                listOf(12, 28, 878),
                "2018-mm-dd",
                8.3,
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg"
            )
        )
        return remoteMovies
    }

    fun getRemoteMoviesDetail(): DetailFilmResponse {
        val movieGenres = listOf(Genre("Drama", 0), Genre("Romance", 1), Genre("Music", 2))
        return DetailFilmResponse(
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "A Star Is Born",
            "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg",
            "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            "2018-mm-dd",
            movieGenres,
            7.5,
            10
        )
    }

    fun getRemoteTvShows(): List<FilmResult> {
        val remoteTvShows = ArrayList<FilmResult>()

        remoteTvShows.add(
            FilmResult(
                20,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                listOf(80, 18, 9648, 10759),
                "2012-mm-dd",
                6.6,
                "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "/fFT7T9y9NVRdcdVh81roVrJBcDh.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                21,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                listOf(10765, 35, 18),
                "2019-mm-dd",
                7.6,
                "/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg",
                "/b7unxzWSFfj7i6UVmuPixxxXFOF.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                22,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                listOf(16, 10759, 10765),
                "1986-mm-dd",
                8.1,
                "/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                "/jipCnOL1aH81wL6CdlrbvHpkueg.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                23,
                "Naruto Shipudden",
                "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans. This time Naruto's mission is to guard Shion, but she predicts Naruto's death. The only way to escape it, is to get away from Shion, which would leave her unguarded, then the demon, whose only goal is to kill Shion will do so, thus meaning the end of the world.",
                listOf(10751, 10759, 16, 14),
                "2007-mm-dd",
                7.1,
                "/n9tyom1Y1vYOMrOGK0jYO3tkby.jpg",
                "/z6ES1hCbLozoquj5wilidrtKBPp.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                24,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                listOf(16, 35),
                "1999-mm-dd",
                7.0,
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "/jbTqU6BJMufoMnPSlO4ThrcXs3Y.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                25,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent.",
                listOf(18, 10765),
                "2014-mm-dd",
                7.7,
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "/bSKlSvNK0CKQ65X0A82smWUBqRO.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                26,
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                listOf(10751, 16, 35),
                "1989-mm-dd",
                7.8,
                "/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg",
                "/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                27,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                listOf(18),
                "2005-mm-dd",
                8.2,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/3IIBf6VlwEyKAX4cN2XCM1gKdgM.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                28,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                listOf(18, 80, 10765),
                "2014-mm-dd",
                7.5,
                "/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg",
                "/7QSM3AsgWXctWBm7OFov9dGdZgt.jpg"
            )
        )
        remoteTvShows.add(
            FilmResult(
                29,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                listOf(16, 35, 10751, 18),
                "2003-mm-dd",
                7.4,
                "/eoj15m14Zpf2bUWXqNIs7itZK9w.jpg",
                "/wsU1R48t2V3cjsbHTj68JoDEo8G.jpg"
            )
        )
        return remoteTvShows
    }

    fun getRemoteTvShowsDetail(): DetailFilmResponse {
        val tvShowGenres = listOf(
            Genre("Crime", 0),
            Genre("Drama", 1),
            Genre("Mystery", 2),
            Genre("Action & Adventure", 3)
        )
        return DetailFilmResponse(
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "Arrow",
            "/fFT7T9y9NVRdcdVh81roVrJBcDh.jpg",
            "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "2012-mm-dd",
            tvShowGenres,
            6.6,
            20
        )
    }
}