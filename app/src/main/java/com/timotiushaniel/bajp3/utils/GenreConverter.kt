package com.timotiushaniel.bajp3.utils

class GenreConverter {
    fun getGenreName(genreIdList: String, type: String): CharSequence {
        val genreName = if (type == "movie") {
            mapOf(
                28 to "Action",
                12 to "Adventure",
                16 to "Animation",
                35 to "Comedy",
                80 to "Crime",
                99 to "Documentary",
                18 to "Drama",
                10751 to "Family",
                14 to "Fantasy",
                36 to "History",
                27 to "Horror",
                10402 to "Music",
                9648 to "Mystery",
                10749 to "Romance",
                878 to "Science Fiction",
                10770 to "TV Movie",
                53 to "Thriller",
                10752 to "War",
                37 to "Western"
            )
        } else {
            mapOf(
                10759 to "Action & Adventure",
                16 to "Animation",
                35 to "Comedy",
                80 to "Crime",
                99 to "Documentary",
                18 to "Drama",
                10751 to "Family",
                10762 to "Kids",
                9648 to "Mystery",
                10763 to "News",
                10764 to "Reality",
                10765 to "Sci-Fi & Reality",
                10766 to "Soap",
                10767 to "Talk",
                10768 to "War & Politics",
                37 to "Western"
            )
        }

        val list = genreIdList.split(", ")
        val showGenre = ArrayList<String>()
        for (genre in list) {
            val name = genreName.getValue(genre.toInt())
            showGenre.add(name)
        }
        return showGenre.toString().replace("[", "").replace("]", "")
    }
}