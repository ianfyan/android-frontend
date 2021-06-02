package com.fs.bansosapp.data.model

import com.google.gson.annotations.SerializedName

data class BansosResponse(

	@field:SerializedName("bansos")
	val bansos: List<BansosItem>
)

data class Location(

	@field:SerializedName("nama")
	val nama: String
)

data class Receipient(

	@field:SerializedName("kewarganegaraan")
	val kewarganegaraan: String,

	@field:SerializedName("nik")
	val nik: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("pekerjaan")
	val pekerjaan: String,

	@field:SerializedName("gol_darah")
	val golDarah: String,

	@field:SerializedName("agama")
	val agama: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("ttl")
	val ttl: String,

	@field:SerializedName("status_perkawinan")
	val statusPerkawinan: String,

	@field:SerializedName("alamat")
	val alamat: String
)

data class BansosItem(

	@field:SerializedName("is_active")
	val isActive: Boolean,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("stock")
	val stock: String,

	@field:SerializedName("location_id")
	val locationId: Int,

	@field:SerializedName("longitude")
	val longitude: String,

	@field:SerializedName("receipient_ids")
	val receipientIds: List<ReceipientIdsItem>
)

data class ReceipientIdsItem(

	@field:SerializedName("receipient")
	val receipient: Receipient
)
