package com.fs.bansosapp.data.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(

	@field:SerializedName("locations")
	val locations: List<LocationsItem>
)

data class LocationsItem(

	@field:SerializedName("provinsi")
	val provinsi: String,

	@field:SerializedName("kota")
	val kota: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("kabupaten")
	val kabupaten: String,

	@field:SerializedName("alamat")
	val alamat: String
)
