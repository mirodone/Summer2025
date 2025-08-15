package com.mirodone.thirtyDays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mirodone.thirtyDays.R


data class Day (
    @DrawableRes val imageRes :Int,
    @StringRes val titleRes : Int,
    @StringRes val informationRes : Int

)

object DayRepo {

    val days = listOf(

        Day(R.drawable.image01_mega_knight, R.string.title_1, R.string.information_1),
        Day(R.drawable.image02_pekka, R.string.title_2, R.string.information_2),
        Day(R.drawable.image03_inferno, R.string.title_3, R.string.information_3),
        Day(R.drawable.image04_lumber, R.string.title_4, R.string.information_4),
        Day(R.drawable.image05_executioner, R.string.title_5, R.string.information_5),
        Day(R.drawable.image06_goblin_drill, R.string.title_6, R.string.information_6),
        Day(R.drawable.image07_arrows, R.string.title_7, R.string.information_7),
        Day(R.drawable.image08_barrel, R.string.title_8, R.string.information_8),
        Day(R.drawable.image09_bats, R.string.title_9, R.string.information_9),
        Day(R.drawable.image010_bomber, R.string.title_10, R.string.information_10),
        Day(R.drawable.image011_bossbandit, R.string.title_11, R.string.information_11),
        Day(R.drawable.image012_cannon, R.string.title_12, R.string.information_12),
        Day(R.drawable.image013_ewiz, R.string.title_13, R.string.information_13),
        Day(R.drawable.image014_firecracker, R.string.title_14, R.string.information_14),
        Day(R.drawable.image015_witch, R.string.title_15, R.string.information_15),
        Day(R.drawable.image016_icewiz, R.string.title_16, R.string.information_16),
        Day(R.drawable.image017_knight, R.string.title_17, R.string.information_17),
        Day(R.drawable.image018_log, R.string.title_18, R.string.information_18),
        Day(R.drawable.image019_magicarcher, R.string.title_19, R.string.information_19),
        Day(R.drawable.image020_mortar, R.string.title_20, R.string.information_20),
        Day(R.drawable.image021_musk, R.string.title_21, R.string.information_21),
        Day(R.drawable.image022_princess, R.string.title_22, R.string.information_22),
        Day(R.drawable.image023_ramrider, R.string.title_23, R.string.information_23),
        Day(R.drawable.image024_royalgiant, R.string.title_24, R.string.information_24),
        Day(R.drawable.image025_skarmy, R.string.title_25, R.string.information_25),
        Day(R.drawable.image026_skeletonking, R.string.title_26, R.string.information_26),
        Day(R.drawable.image027_skellies, R.string.title_27, R.string.information_27),
        Day(R.drawable.image028_tesla, R.string.title_28, R.string.information_28),
        Day(R.drawable.image029_valk, R.string.title_29, R.string.information_29),
        Day(R.drawable.image030_wizard, R.string.title_30, R.string.information_30),
    )


}