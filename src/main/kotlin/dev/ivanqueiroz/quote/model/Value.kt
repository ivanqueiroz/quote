package dev.ivanqueiroz.quote.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(
    var id: Long,
    var quote: String
) {
    constructor() : this(0L, "")

    override fun toString(): String {
        return "Value(id=$id, quote='$quote')"
    }

}
