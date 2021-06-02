package com.fs.bansosapp.data.model

import com.google.gson.annotations.SerializedName

data class RecipientResponse(

	@field:SerializedName("receipients")
	val receipients: List<ReceipientsItem>
)

data class ReceipientsItem(

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
