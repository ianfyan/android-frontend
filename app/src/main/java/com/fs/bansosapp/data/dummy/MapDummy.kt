package com.fs.bansosapp.data.dummy

import com.google.android.gms.maps.model.LatLng

object MapDummy {
    fun getMap(): ArrayList<LatLng> {
        val listMarker: ArrayList<LatLng> = ArrayList()
        listMarker.add(LatLng(-7.257696609001408, 112.74760570042055))
        listMarker.add(LatLng(-7.800131364803854, 110.39141221022824))
        listMarker.add(LatLng(-6.911707432020603, 107.60963649672443))
        listMarker.add(LatLng(-6.170302243562764, 106.82744443430127))
        listMarker.add(LatLng(-8.029995514991295, 112.64339998957783))
        return listMarker
    }
}