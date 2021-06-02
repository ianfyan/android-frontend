package com.fs.bansosapp.data.model.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ProfilResponse(

	@field:SerializedName("admins")
	val admins: List<AdminsItem>
)

data class AdminsItem(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("write_access")
	val writeAccess: Boolean
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		parcel.readInt(),
		parcel.readString()!!,
		parcel.readByte() != 0.toByte()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(nama)
		parcel.writeInt(id)
		parcel.writeString(email)
		parcel.writeByte(if (writeAccess) 1 else 0)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<AdminsItem> {
		override fun createFromParcel(parcel: Parcel): AdminsItem {
			return AdminsItem(parcel)
		}

		override fun newArray(size: Int): Array<AdminsItem?> {
			return arrayOfNulls(size)
		}
	}
}
