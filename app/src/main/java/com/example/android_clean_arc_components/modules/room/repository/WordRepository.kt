package com.example.android_clean_arc_components.modules.room.repository

import androidx.lifecycle.LiveData
import com.example.android_clean_arc_components.modules.room.model.Word
import com.example.android_clean_arc_components.modules.room.model.WordDao

class WordRepository (private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}