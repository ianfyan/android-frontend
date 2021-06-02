package com.fs.bansosapp.data.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse(

	@field:SerializedName("transactions")
	val transactions: List<TransactionsItem>
)

data class Recipient(

	@field:SerializedName("nik")
	val nik: String,

	@field:SerializedName("nama")
	val nama: String
)

data class Locations(

	@field:SerializedName("nama")
	val nama: String
)

data class Bansos(

	@field:SerializedName("location")
	val location: Locations
)

data class TransactionsItem(

	@field:SerializedName("receipient")
	val receipient: Recipient,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("bansos")
	val bansos: Bansos
)
