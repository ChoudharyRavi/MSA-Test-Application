package com.sample.jetpack.msatestapplication.domain.model

import com.google.gson.annotations.SerializedName

data class Business(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)