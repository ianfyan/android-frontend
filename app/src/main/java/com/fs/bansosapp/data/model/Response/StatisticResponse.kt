package com.fs.bansosapp.data.model

import com.google.gson.annotations.SerializedName

data class StatisticResponse(

	@field:SerializedName("locations_aggregate")
	val locationsAggregate: LocationsAggregate,

	@field:SerializedName("transactions_aggregate")
	val transactionsAggregate: TransactionsAggregate,

	@field:SerializedName("receipientMap_aggregate")
	val receipientMapAggregate: ReceipientMapAggregate,

	@field:SerializedName("bansos_aggregate")
	val bansosAggregate: BansosAggregate
)

data class ReceipientMapAggregate(

	@field:SerializedName("aggregate")
	val aggregate: Aggregate
)

data class TransactionsAggregate(

	@field:SerializedName("aggregate")
	val aggregate: Aggregate
)

data class LocationsAggregate(

	@field:SerializedName("aggregate")
	val aggregate: Aggregate
)

data class Aggregate(

	@field:SerializedName("count")
	val count: Int
)

data class BansosAggregate(

	@field:SerializedName("aggregate")
	val aggregate: Aggregate
)
