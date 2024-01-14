package com.shifat.smarthallcatering

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

fun textGen(words:Int): String
{

    val desc = LoremIpsum(words).values.iterator()

    var des: String="";

    for( word in desc)
    {
        des+= word
    }
   return des;
}