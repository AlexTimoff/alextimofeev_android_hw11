package com.example.alextimofeev_android_hw11

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

private const val PREFERENCE_NAME = "data_store"
private const val KEY_STRING_NAME = "shared_prefs"

class Repository(context: Context) {
    private var value: String?=null
    private val prefs=context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)

    //Метод, который будет записывать значения и в SharedPreference, и в локальную переменную.
    fun saveText(text: String) {
        saveToSharedPreference(text)
        saveToLocalValue(text)
    }

    //Метод, записывающий значение в SharedPreference
    private fun saveToSharedPreference(text: String) {
        val editor:SharedPreferences.Editor = prefs.edit()
        editor.putString(KEY_STRING_NAME, text)
        editor.apply()
    }

    //Метод, записывающий значение в локальную переменную
    private fun saveToLocalValue(text: String) {
        value=text
    }


    //Метод, который будет доставать значение из SharedPreference
    private fun getDataFromSharedPreference(): String? {
        return prefs.getString(KEY_STRING_NAME,null)
    }

    //Метод, возвращающий значение локальной переменной
    private fun getDataFromLocalVariable(): String? {
        return value
    }

    //Метод, достающий значение из источников

    fun getText():String{
        return when {
            getDataFromLocalVariable()!=null ->getDataFromLocalVariable()!!
            getDataFromSharedPreference()!=null ->getDataFromSharedPreference()!!
            else -> ""
        }

    }

    //Метод, очищающий значения и в SharedPreference, и в локальной переменной.
    fun clearText() {
        value = null
        val editor = prefs.edit()
        editor.remove(KEY_STRING_NAME)
        editor.apply()
    }

}