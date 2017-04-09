package com.marcinmoskala.model

class Achievement(
        val nameT: String,
        val detailT: String,
        val dateT: String,
        val jobT: String,
        val icon: String,
        val link: String? = null
) {
    constructor(nameT: String, icon: String, link: String? = null) : this(nameT, nameT + "_des", nameT + "_date", nameT + "_job", icon, link)
}