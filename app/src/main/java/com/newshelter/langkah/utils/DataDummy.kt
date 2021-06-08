package com.newshelter.langkah.utils

import com.newshelter.langkah.data.*

object DataDummy {

    fun generateDummyHospital(): List<HosptalEntity>{
        val hospital = ArrayList<HosptalEntity>()

        val polyclinics = generateDummyPolyclinics()

        val doctors = generateDummyDoctors()

        val rooms = generateDummyRoom()

        hospital.add(
                HosptalEntity(
                        "hos-01",
                        "RSUPN Dr. Ciptomangunkusumo",
                        "RSCM atau Rumah Sakit Pusat Nasional Umum  Dr. Cipto Mangunkusumo adalah \n" +
                                "rumah sakit umum milik pemerintah dengan pelayanan terlengkap di Indonesia. \n" +
                                "Status tersebut diberikan melalui SK Menkes no YM.01.10/III/2212/2009.",
                        "Jl. Pangeran Diponegoro No.71, RW.5, Kenari, Kec. Senen, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10430",
                        "0211500135",
                    """ATtYBwKW89VakCHjBWy_7TxXvG1HhC57iQ9RiZMD_K_apj6z0iLQ2Q_rVoFYr8Jz9xZy5RZH3WO8KKQffIXZsHHJk8BU9PCXM83N0tJ-2J6B7-ws_KpqhTDcuC366_7ZUoMPjFTTkeIgBDNXhTTr3llHCM5VJKEEaycdrQYFUKRxjLiohCci""",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                        "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms,
                    -6.1971523,
                    106.8468688

                )
        )

        hospital.add(
                HosptalEntity(
                        "hos-02",
                        "Rumah Sakit Cipto Mangunkusumo Kencana",
                        "Rumah sakit Cipto Mangunkusumo Kencana merupakan \n" +
                                "rumah sakit di bawah Kementerian Kesehatan RI yang Menawarkan konsep pelayanan kesehatan.",
                        "Jl. Pangeran Diponegoro No.71, RW.5, \n" +
                                "Kenari, Kec. Senen, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10430",
                        "0211500135",
                    "ATtYBwIPJOfbw2wwDLtfJwgdpx9h5PDDtMjO37t3qqgAcmSfcHmTEulyVj0WEuSO5tQ1WO-9uzKOTUjPRLGDsPRBIUd50cEOqPfGAXZgMwEhUURddySsWfOlLSh8BdP57jrRdD0IAQkv5NLeFjDvq_MW2G4hMvbN5nyGTNWRosX_deW0zVjt",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir","kantin","fotocopy"),
                        polyclinics,
                        doctors,
                        rooms,
                    -6.1986549,
                    106.8458209
                )
        )

        hospital.add(
                HosptalEntity(
                        "hos-03",
                        "Rumah Sakit Abdi Waluyo Jkt",
                        "RSCM atau Rumah Sakit Pusat Nasional Umum  Dr. Cipto Mangunkusumo adalah \n" +
                                "rumah sakit umum milik pemerintah dengan pelayanan terlengkap di Indonesia. \n" +
                                "Status tersebut diberikan melalui SK Menkes no YM.01.10/III/2212/2009.",
                        "Jl. HOS. Cokroaminoto No.31-33, RT.1/RW.3, \n" +
                                "Gondangdia, Kec. Menteng, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10350",
                        "0213140524",
                    "ATtYBwKCoezXjUSRqqyG-ByP9I8lf78BMbt5iHtGe9sU_3PWGtIfccQgY3RvONo1cL72myZkteQq95kCpeKfUp99r7vr7ZnmS_xfV9ia5fy5W6Xd0ExvVjbFrMpCvAUR3o10q3BJC5ithd95xqmYIpTHielBo8eA2pOMyBpoeKXYCR1SaWN1",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms,
                    -6.1898346,
                    106.8292723
                )
        )

        hospital.add(
                HosptalEntity(
                        "hos-04",
                        "RSIA BUNDA JAKARTA",
                        "Rumah Sakit Bunda berangkat dari praktek pribadi Pendiri, Dr. Rizal Sini SpOG  \n" +
                                "yang waktu itu ditahun 1969 adalah pegawai negeri sipil, staf pengajar pada FKUI \n",
                    "Jl. Teuku Cik Ditiro No.28, RT.9/RW.2, \n" +
                                "Gondangdia, Kec. Menteng, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10350",
                        "0211500799",
                    "ATtYBwJ_mMAAeUDnxRbzoqTgUzgLZ1ZTPu9snep14iKXJKcWLMIVNiQYXsjhKuTYXofw-dnCYBWF6BSn9KAtAZ8X4gDU8nSuTrdFa_g3qv78HMwwd2ZcnwXWiQ7nrnlinkn7qSvkUfcqVkUmDMoNBSkyWFwSMkEI5CDfmBfZSvPuNe05GPnk",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms,
                    -6.196034,
                    106.8364554
                )
        )

        return hospital
    }

    fun generateDummyDoctors(): List<DoctorsEntity>{

        val doctor = ArrayList<DoctorsEntity>()

        doctor.add(
                DoctorsEntity(
                        "doc-01",
                        "Prof. dr Arwin Ali Purbaya Akib, Sp.A(K)",
                        "Spesialis Anak",
                        "Prof. dr. Arwin Ali Purbaya Akib, Sp.A(K) merupakan seorang dokter spesialis anak konsultan. Saat ini beliau berpraktik di RS PELNI di Jakarta Barat, RS Cipto Mangunkusumo - Kencana di Jakarta Pusat",
                )

        )

        doctor.add(
                DoctorsEntity(
                        "doc-02",
                        "dr. Ahmad Kurnia, Sp.B Onkt",
                        "Spesialis Bedah",
                        "Prof. dr. Arwin Ali Purbaya Akib, Sp.A(K) merupakan seorang dokter spesialis anak konsultan. Saat ini beliau berpraktik di RS PELNI di Jakarta Barat, RS Cipto Mangunkusumo - Kencana di Jakarta Pusat",
                )

        )

        return doctor
    }

    fun generateDummyPolyclinics(): List<PolyclinicsEntity>{

        val poly = ArrayList<PolyclinicsEntity>()

        poly.add(
                PolyclinicsEntity(
                        "poly-01",
                        "Cluster Pediatric",
                        "Pediatri atau ilmu kesehatan anak ialah spesialisasi kedokteran yang berkaitan dengan bayi dan anak. Kata pediatri diambil dari dua kata Yunani kuno, paidi yang berarti \"anak\" dan iatros yang berarti \"dokter\". Praktisi medis yang memiliki spesialisasi dalam pediatri dinamakan dokter anak."
                )
        )
        poly.add(
                PolyclinicsEntity(
                        "poly-02",
                        "Poli Bedah Saraf",
                        "Pediatri atau ilmu kesehatan anak ialah spesialisasi kedokteran yang berkaitan dengan bayi dan anak. Kata pediatri diambil dari dua kata Yunani kuno, paidi yang berarti \"anak\" dan iatros yang berarti \"dokter\". Praktisi medis yang memiliki spesialisasi dalam pediatri dinamakan dokter anak."
                )
        )

        return poly

    }

    fun generateDummyRoom() : List<RoomEntity>{

        val room = ArrayList<RoomEntity>()

        room.add(
                RoomEntity(
                        "room-01",
                        "VIP",
                    "Rp 1.500.000, 00",
                "Rp 150.000, 00",
                "Rp 250.000, 00",
                    "Rp 150.000, 00"
                )
        )

        room.add(
                RoomEntity(
                        "room-02",
                        "VVIP",
                    "Rp 2.500.000, 00",
                    "Rp 250.000, 00",
                    "Rp 350.000, 00",
                    "Rp 250.000, 00"
                )
        )

        room.add(
                RoomEntity(
                        "room-03",
                        "Kelas I",
                    "Rp 1.000.000, 00",
                    "Rp 100.000, 00",
                    "Rp 200.000, 00",
                    "Rp 100.000, 00"
                )
        )

        return room
    }

    fun generateDummySchedule() : List<ScheduleEntity>{
        val sch = ArrayList<ScheduleEntity>()

        sch.add(
            ScheduleEntity(
                "sch-01",
                "hos-01",
                "doc-01",
                arrayListOf("Monday 09:00-12:00", "Tuesday 12:00-15:00")
            )
        )


        sch.add(
            ScheduleEntity(
                "sch-02",
                "hos-02",
                "doc-01",
                arrayListOf("Tuesday 12:00-15:00", "Wednesday 12:00-15:00")
            )
        )

        sch.add(
            ScheduleEntity(
                "sch-03",
                "hos-01",
                "doc-02",
                arrayListOf("Tuesday 12:00-15:00", "Thursday 12:00-15:00")
            )
        )


        sch.add(
            ScheduleEntity(
                "sch-04",
                "hos-02",
                "doc-02",
                arrayListOf("Friday 12:00-15:00")
            )
        )



        return sch
    }

    fun generateDummyPolySchedule() : List<PolyScheduleEntity>{

        val sch = ArrayList<PolyScheduleEntity>()

        sch.add(
            PolyScheduleEntity(
                "sch-05",
                "hos-01",
                "poly-01",
                arrayListOf("Monday 09:00-12:00", "Tuesday 12:00-15:00")
            )
        )


        sch.add(
            PolyScheduleEntity(
                "sch-06",
                "hos-02",
                "poly-01",
                arrayListOf("Tuesday 12:00-15:00", "Wednesday 12:00-15:00")
            )
        )

        sch.add(
            PolyScheduleEntity(
                "sch-07",
                "hos-01",
                "poly-02",
                arrayListOf("Tuesday 12:00-15:00", "Thursday 12:00-15:00")
            )
        )


        sch.add(
            PolyScheduleEntity(
                "sch-08",
                "hos-02",
                "poly-02",
                arrayListOf("Friday 12:00-15:00")
            )
        )



        return sch
    }

    fun generateDummyUser() : List<UserEntity>{
        val users = ArrayList<UserEntity>()

        users.add(
            UserEntity(
                "user-01",
                "janedoe@example.com",
                "Jane Doe",
                "12345",
                "082187645379",
                "Perumahan Resinda Blok blabla, Karawang, Indonesia",
            "",
                "3",
                ""
            )
        )

        users.add(
            UserEntity(
                "user-02",
                "williamscorch@example.com",
                "William Scorch",
                "12345",
                "082187645379",
                "Perumahan Resinda Blok blabla, Karawang, Indonesia",
                "",
                "2",
                ""
            )
        )

        users.add(
            UserEntity(
                "user-03",
                "xaviertone@example.com",
                "Xavier Tone",
                "12345",
                "",
                "",
                "",
                "1",
                "1999-08-01"
            )
        )

        return users
    }

    fun generateDummyAppointment() : List<AppointmentEntity>{

        val appointments = ArrayList<AppointmentEntity>()

        appointments.add(
            AppointmentEntity(
                "app-01",
                "user-02",
                "18",
                "hos-01",
                "poly-01",
                "doc-01",
                "21-09-12",
                "09:00"
            )
        )

        appointments.add(
            AppointmentEntity(
                "app-02",
                "user-03",
                "21",
                "hos-01",
                "poly-01",
                "doc-01",
                "21-09-16",
                "09:15"
            )
        )

        return appointments
    }

    fun generateDummyQuestions() : List<String>{
        val questions = arrayListOf("gatal",
            "ruam kulit",
            "erupsi kulit nodal",
            "bersin terus-menerus",
            "gemetaran",
            "panas dingin",
            "nyeri sendi",
            "sakit perut",
            "keasaman",
            "luka di lidah",
            "menghilangkan otot",
            "muntah",
            "membakar mikturisi",
            "bercak kencing",
            "kelelahan",
            "menambah berat badan",
            "kegelisahan",
            "tangan dan kaki dingin",
            "perubahan suasana hati",
            "penurunan berat badan",
            "kegelisahan",
            "kelesuan",
            "tambalan di tenggorokan",
            "kadar gula tidak teratur",
            "batuk",
            "demam tinggi",
            "mata cekung",
            "sesak napas",
            "berkeringat",
            "dehidrasi",
            "gangguan pencernaan",
            "sakit kepala",
            "kulit kekuningan",
            "urin gelap",
            "mual",
            "kehilangan selera makan",
            "sakit di belakang mata",
            "sakit punggung",
            "sembelit",
            "sakit perut",
            "diare",
            "demam ringan",
            "urin kuning",
            "mata menguning",
            "gagal hati akut",
            "kelebihan cairan",
            "perut kembung",
            "pembengkakan kelenjar getah bening",
            "rasa tidak enak",
            "penglihatan kabur dan terdistorsi",
            "dahak",
            "iritasi tenggorokan",
            "mata merah",
            "tekanan sinus",
            "pilek",
            "kemacetan",
            "nyeri dada",
            "kelemahan pada anggota badan",
            "detak jantung cepat",
            "nyeri saat buang air besar",
            "nyeri di daerah anus",
            "tinja berdarah",
            "iritasi pada anus",
            "sakit leher",
            "pusing",
            "kram",
            "memar",
            "kegemukan",
            "kaki bengkak",
            "pembuluh darah bengkak",
            "wajah dan mata bengkak",
            "pembesaran tiroid",
            "kuku rapuh",
            "ekstremitas bengkak",
            "kelaparan berlebihan",
            "kontak pernikahan ekstra",
            "bibir kering dan kesemutan",
            "bicara tidak jelas",
            "sakit lutut",
            "nyeri sendi pinggul",
            "kelemahan otot",
            "leher kaku",
            "sendi bengkak",
            "kekakuan gerakan",
            "gerakan berputar",
            "kehilangan keseimbangan",
            "kegoyangan",
            "kelemahan satu sisi tubuh",
            "hilangnya bau",
            "ketidaknyamanan kandung kemih",
            "bau urin yang tidak sedap",
            "kencing terus menerus",
            "lintasan gas",
            "gatal dalam",
            "tampilan beracun (tipos)",
            "depresi",
            "sifat lekas marah",
            "nyeri otot",
            "sensorium yang diubah",
            "bintik merah di sekujur tubuh",
            "sakit perut",
            "menstruasi tidak normal",
            "tambalan diskromik",
            "berair dari mata",
            "nafsu makan meningkat",
            "poliuria",
            "sejarah keluarga",
            "dahak mukoid",
            "dahak berkarat",
            "kurang konsenterasi",
            "gangguan penglihatan",
            "menerima transfusi darah",
            "menerima suntikan yang tidak steril",
            "koma",
            "perut berdarah",
            "distensi perut",
            "riwayat konsumsi alkohol",
            "kelebihan cairan.1",
            "darah dalam dahak",
            "vena menonjol di betis",
            "palpitasi",
            "jalan yang menyakitkan",
            "jerawat berisi nanah",
            "komedo",
            "berlari",
            "kulit mengelupas",
            "perak seperti debu",
            "penyok kecil di kuku",
            "kuku radang",
            "lepuh",
            "sakit merah di sekitar hidung",
            "cairan kerak kuning")

        return questions
    }
}