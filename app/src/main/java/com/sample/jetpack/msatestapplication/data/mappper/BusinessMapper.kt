package com.sample.jetpack.msatestapplication.data.mappper

import com.sample.jetpack.msatestapplication.data.dto.BusinessesItem
import com.sample.jetpack.msatestapplication.domain.model.Business


fun BusinessesItem.toDomainCharacter(): Business {
    return Business(
        name = name,
        image = imageUrl,
        id = id
    )
}