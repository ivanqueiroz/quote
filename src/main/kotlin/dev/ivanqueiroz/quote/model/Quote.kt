package dev.ivanqueiroz.quote.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(
    var type: String = "",
    var value: Value = Value()
) {
    constructor() : this("", Value())

    override fun toString(): String {
        return "Quote(type='$type', value=$value)"
    }
}
