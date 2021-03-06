package io.github.droidkaigi.confsched2020.data.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.droidkaigi.confsched2020.data.db.internal.entity.SponsorEntityImpl
import kotlinx.coroutines.flow.Flow

@Dao
internal abstract class SponsorDao {
    @Query("SELECT * FROM sponsor ORDER BY sort")
    abstract fun allSponsors(): Flow<List<SponsorEntityImpl>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(sponsors: List<SponsorEntityImpl>)

    @Query("DELETE FROM sponsor")
    abstract fun deleteAll()
}
