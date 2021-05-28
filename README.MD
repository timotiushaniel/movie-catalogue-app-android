SKENARIO UNIT TESTING (Menggunakan data lokal pada file DataDummy):
1. MoviesViewModelTest:
    > Memuat Movies:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository
        - Memastikan metode di kelas repository terpanggil
        - Memastikan data movies tidak null
        - Membandingkan dan memastikan jumlah data movies antara moviesResponse dengan moviesEntities sesuai dengan yang diharapkan
2. TvShowViewModelTest:
    > Memuat Tv Shows:
        - Memanipulasi data ketika pemanggilan data Tv show di kelas repository
        - Memastikan metode di kelas repository terpanggil
        - Memastikan data tv show tidak null
        - Membandingkan dan memastikan jumlah data tv show antara tvShowsResponse dengan tvShowEntities sesuai dengan yang diharapkan
3. DetailViewModelTest:
    > Memuat Movies:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository
        - Memastikan metode di kelas repository terpanggil
        - Memastikan data movie tidak null
        - Membandingkan data movie yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
    > Memuat Tv Shows:
         - Memanupulasi data ketika pemanggilan data Tv show di kelas repository
         - Memastikan metode di kelas repository terpanggil
         - Memastikan data tv shows tidak null
         - Membandingkan data Tv Shows yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
4. FilmRepositoryTest:
	> Memuat Tv Shows:
		- Memanipulasi data ketika pemanggilan data Tv Show di kelas entity
		- Memastikan data tv show tidak null
		- Membandingkan dan memastikan jumlah data tvShowsResponse dengan tvShowEntities sesuai dengan yang diharapkan
	> Memuat Movies:
		- Memanipulasi data ketika pemanggilan data movies di kelas entity
		- Memastikan data movies tidak null
		- Membandingkan dan memastikan jumlah data moviesResponse dengan moviesEntities sesuai dengan yang diharapkan
	> Memuat Detail movies:
		- Memanipulasi data detail ketika pemanggilan data di kelas entity
		- Mengambil data dummy pada class data dummy get movies detail
		- Memastikan data movies detail tidak null
		- Membandingkan data movie yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Memuat Detail Tv Shows:
		- Memanipulasi data detail ketika pemanggilan data di kelas entity
		- Mengambil data dummy pada class data dummy get Tv Shows detail
		- Memastikan data Tv Shows detail tidak null
		- Membandingkan data Tv Shows yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Memuat favorite movies:
		- Mengambil data dummy pada class data dummy get movies detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
		- Memastikan data movies detail tidak null
		- Membandingkan data movie yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Memuat favorite Tv Shows:
		- Mengambil data dummy pada class data dummy get Tv Shows detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
		- Memastikan data Tv Shows detail tidak null
		- Membandingkan data Tv Shows yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Men-set favorite movies:
		- Mengambil data dummy pada class data dummy get movies detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
	> Men-set favorite Tv Shows:
		- Mengambil data dummy pada class data dummy get Tv Shows detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
5. FavoriteMoviesViewModelTest:
	> Memuat favorite movies:
		- Mengambil data dummy favorite sebanyak 5 buah
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
		- Memastikan data movies detail tidak null
		- Membandingkan data movie yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Men-set favorite movies:
		- Mengambil data dummy pada class data dummy get movies detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
6. FavoriteTvShowViewModelTest:
	> Memuat favorite TvShow:
		- Mengambil data dummy favorite sebanyak 5 buah
		- Menjadikan data dummy yang diambil sebagai data dummy favorite
		- Memastikan data TvShow detail tidak null
		- Membandingkan data TvShow yang dipilih sesuai dengan yang diharapkan (id, title, release year, genre, dll)
	> Men-set favorite TvShow:
		- Mengambil data dummy pada class data dummy get TvShow detail
		- Menjadikan data dummy yang diambil sebagai data dummy favorite

SKENARIO INSTRUMENTAL TESTING:
1. Menampilkan data movie:
    > Memberi tindakan klik tab MOVIE
    > Memastikan rv_movie dalam keadaan tampil
    > Gulir rv_movie ke posisi data terakhir
2. Menampilkan data detail pada data movie:
    > Memberi tindakan klik tab MOVIE
    > Memberi tindakan klik pada data pertama di rv_movie
    > Memastikan ImageView untuk img_item_preview dapat tampil
    > Memastikan TextView untuk title dapat tampil sesuai dengan yang diharapkan
	> Memastikan TextView untuk release date dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk description dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk rating dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk genre dapat tampil sesuai dengan yang diharapkan
    > Memastikan ImageView untuk img_item_photo dapat tampil
3. Menampilkan data TV show:
    > Memberi tindakan klik tab TV SHOW
    > Memastikan rv_tv_show dalam keadaan tampil
    > Gulir rv_tv_show ke posisi data terakhir
4. Menampilkan data detail pada data TV Show:
    > Memberi tindakan klik tab TV SHOW
    > Memberi tindakan klik pada data pertama di rv_tv_show
    > Memastikan ImageView untuk img_item_preview tampil
    > Memastikan TextView untuk title dapat tampil sesuai dengan yang diharapkan
	> Memastikan TextView untuk release date dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk description dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk rating dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk genre dapat tampil sesuai dengan yang diharapkan
    > Memastikan ImageView untuk img_item_photo dapat tampil
5. Menampilkan data favorite movie (Data pertama yang muncul di list movie harus dalam status NOT FAVORITE):
    > Memberi tindakan klik tab MOVIE
    > Memberi tindakan klik pada data pertama di rv_movie
	> Menekan tombol favorite (fab) agar status item menjadi FAVORITE
	> Kembali ke halaman utama
	> Menekan tombol hati untuk berpindah ke activity favorite
	> Memberi tindakan klik tab MOVIE
	> Memberi tindakan klik pada data pertama di rv_movie_favorite
    > Memastikan ImageView untuk img_item_preview dapat tampil
    > Memastikan TextView untuk title dapat tampil sesuai dengan yang diharapkan
	> Memastikan TextView untuk release date dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk description dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk rating dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk genre dapat tampil sesuai dengan yang diharapkan
    > Memastikan ImageView untuk img_item_photo dapat tampil
	> Menekan tombol favorite (fab) agar status item menjadi NOT FAVORITE
6. Menampilkan data favorite tv show (Data pertama yang muncul di list tv show harus dalam status NOT FAVORITE):
    > Memberi tindakan klik tab TV SHOW
    > Memberi tindakan klik pada data pertama di rv_tv show
	> Menekan tombol favorite (fab) agar status item menjadi FAVORITE
	> Kembali ke halaman utama
	> Menekan tombol hati untuk berpindah ke activity favorite
	> Memberi tindakan klik tab TV SHOW
	> Memberi tindakan klik pada data pertama di rv_tv show_favorite
    > Memastikan ImageView untuk img_item_preview dapat tampil
    > Memastikan TextView untuk title dapat tampil sesuai dengan yang diharapkan
	> Memastikan TextView untuk release date dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk description dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk rating dapat tampil sesuai dengan yang diharapkan
    > Memastikan TextView untuk genre dapat tampil sesuai dengan yang diharapkan
    > Memastikan ImageView untuk img_item_photo dapat tampil
	> Menekan tombol favorite (fab) agar status item menjadi NOT FAVORITE