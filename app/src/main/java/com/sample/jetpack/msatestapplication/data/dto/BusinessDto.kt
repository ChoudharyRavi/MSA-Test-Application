package com.sample.jetpack.msatestapplication.data.dto

import com.google.gson.annotations.SerializedName

data class BusinessDto(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("region")
	val region: Region? = null,

	@field:SerializedName("businesses")
	val businesses: ArrayList<BusinessesItem?>? = null
)

data class BusinessHoursItem(

	@field:SerializedName("is_open_now")
	val isOpenNow: Boolean? = null,

	@field:SerializedName("hours_type")
	val hoursType: String? = null,

	@field:SerializedName("open")
	val open: List<OpenItem?>? = null
)

data class BusinessesItem(

	@field:SerializedName("business_hours")
	val businessHours: List<BusinessHoursItem?>? = null,

	@field:SerializedName("distance")
	val distance: Any? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("coordinates")
	val coordinates: Coordinates? = null,

	@field:SerializedName("review_count")
	val reviewCount: Int? = null,

	@field:SerializedName("transactions")
	val transactions: List<String?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("display_phone")
	val displayPhone: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("alias")
	val alias: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("is_closed")
	val isClosed: Boolean? = null,

	@field:SerializedName("price")
	val price: String? = null
)

data class CategoriesItem(

	@field:SerializedName("alias")
	val alias: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Region(

	@field:SerializedName("center")
	val center: Center? = null
)

data class Center(

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)

data class Coordinates(

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)

data class Attributes(

	@field:SerializedName("waitlist_reservation")
	val waitlistReservation: Any? = null,

	@field:SerializedName("open24_hours")
	val open24Hours: Any? = null,

	@field:SerializedName("menu_url")
	val menuUrl: String? = null,

	@field:SerializedName("business_temp_closed")
	val businessTempClosed: Any? = null
)

data class Location(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("address3")
	val address3: String? = null,

	@field:SerializedName("address2")
	val address2: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("address1")
	val address1: String? = null,

	@field:SerializedName("display_address")
	val displayAddress: List<String?>? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("zip_code")
	val zipCode: String? = null
)

data class OpenItem(

	@field:SerializedName("is_overnight")
	val isOvernight: Boolean? = null,

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("end")
	val end: String? = null,

	@field:SerializedName("day")
	val day: Int? = null
)
