package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.MovieWithActor

@Dao
interface ActorDao {
    @Query("SELECT * FROM actor_table")
    suspend fun getAllActor(): List<ActorModel>

    @Transaction
    @Insert
    suspend fun insertActor(movie: ActorModel)

}
