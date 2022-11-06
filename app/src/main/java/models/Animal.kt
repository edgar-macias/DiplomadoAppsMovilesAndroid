package models

import androidx.annotation.DrawableRes
import java.io.Serializable
data class Animal(
    val id:Int,
    val name:String,
    @DrawableRes
    val img:Int?
):Serializable