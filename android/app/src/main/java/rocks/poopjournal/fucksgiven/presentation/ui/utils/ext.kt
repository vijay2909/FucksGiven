package rocks.poopjournal.fucksgiven.presentation.ui.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

val dateComponentFormatter = LocalDate.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    day(Padding.ZERO)
}

@OptIn(ExperimentalTime::class)
fun getFormattedDate(timestamp: Long): String {
    // DatePicker gives date in milliseconds since epoch UTC)
    val localDate = Instant.fromEpochMilliseconds(timestamp).toLocalDateTime(TimeZone.UTC).date

    return localDate.format(dateComponentFormatter)
}

fun isToday(dateString: String): Boolean {
    val todayString = getFormattedDate(System.currentTimeMillis())
    return dateString == todayString
}