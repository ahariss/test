package com.ahariss.test.config

object Global {
    val DOMAIN : String = "https://gateway.marvel.com:443/"
    val BASE_URL :String = "${DOMAIN}v1/public/"
    val PUBLIC_KEY :String = "76aa9b37cddca9b751193f20c37e4514"
    val PRIVATE_KEY :String = "de7a0623d76579397e2250d0e2718cd465d643e3"


    const val CHARACTERS_URL: String = "characters"
    val CHARACTER_URL: String = "characters/{characterId}"
    val COMICS_URL: String = "characters/{characterId}/comics"
    val EVENTS_URL: String = "characters/{characterId}/events"
    val SERIES_URL: String = "characters/{characterId}/series"
    val STORIES_URL: String = "characters/{characterId}/stories"
}