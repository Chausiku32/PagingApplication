package nixmar.chausiku32.pagingapplication.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nixmar.chausiku32.pagingapplication.model.Repo

@Dao
interface RepoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repos: List<Repo>)

    @Query("SELECT * FROM repos WHERE (name LIKE :queryString) OR (description LIKE :queryString) ORDER BY stars DESC, name ASC ")
    fun reposByName(queryString: String): DataSource.Factory<Int, Repo>
}