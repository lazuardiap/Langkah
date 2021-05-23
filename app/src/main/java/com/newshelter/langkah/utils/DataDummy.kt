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
                        "0821342213213",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                        "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms

                )
        )

        hospital.add(
                HosptalEntity(
                        "hos-02",
                        "Rumah Sakit Abdi Waluyo Jkt",
                        "RSCM atau Rumah Sakit Pusat Nasional Umum  Dr. Cipto Mangunkusumo adalah \n" +
                                "rumah sakit umum milik pemerintah dengan pelayanan terlengkap di Indonesia. \n" +
                                "Status tersebut diberikan melalui SK Menkes no YM.01.10/III/2212/2009.",
                        "Jl. HOS. Cokroaminoto No.31-33, RT.1/RW.3, \n" +
                                "Gondangdia, Kec. Menteng, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10350",
                        "0821342213213",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms
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
                        "0821342213213",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms
                )
        )

        hospital.add(
                HosptalEntity(
                        "hos-04",
                        "Rumah Sakit Abdi Waluyo Jkt",
                        "RSCM atau Rumah Sakit Pusat Nasional Umum  Dr. Cipto Mangunkusumo adalah \n" +
                                "rumah sakit umum milik pemerintah dengan pelayanan terlengkap di Indonesia. \n" +
                                "Status tersebut diberikan melalui SK Menkes no YM.01.10/III/2212/2009.",
                        "Jl. HOS. Cokroaminoto No.31-33, RT.1/RW.3, \n" +
                                "Gondangdia, Kec. Menteng, Kota Jakarta Pusat, \n" +
                                "Daerah Khusus Ibukota Jakarta 10350",
                        "0821342213213",
                        arrayListOf("Pelayanan Rawat Jalan", "Pelayanan Rawat Inap", "Pelayanan Gudang", "Rumah Singgah",
                                "Masjid/Mushola", "Tempat Parkir"),
                        polyclinics,
                        doctors,
                        rooms
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
}