package com.garif.testtaskforhammersystems.feature.menu.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey
    val name: String,
)
