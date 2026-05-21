package com.example.petjetpackcomposeapp

import android.content.Context
import com.example.petjetpackcomposeapp.InvalidCounterValueException
import java.lang.Exception

fun interface ExceptionMessageMapper {

    fun toUserMessage(context: Context, exception: Exception): String

    companion object {
        val DEFAULT = ExceptionMessageMapper { context, exception ->
            when (exception) {
                is InvalidCounterValueException -> {
                    context.getString(
                        R.string.your_counter_value_is_out_of_bounds,
                        exception.value,
                        exception.minValue,
                        exception.maxValue
                    )
                }
                else -> context.getString(R.string.unknown_error)
            }
        }
    }
}