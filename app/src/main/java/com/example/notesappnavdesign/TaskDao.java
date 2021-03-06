package com.example.notesappnavdesign;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("Select * FROM ItemTask ORDER BY task_Date")
    LiveData<List<ItemTask>> getAllTask();

    @Query("DELETE FROM itemtask WHERE tId=:id")
    void deleteById(int id);

    @Query("Select * FROM ItemTask WHERE task_Date=strftime('%d-%m-%Y','now')")
    LiveData<List<ItemTask>> getTodayTask();

    @Query("Select * FROM ItemTask WHERE task_Importance=1 ORDER BY task_Date")
    LiveData<List<ItemTask>> getImportantTask();

    @Query("Select * FROM ItemTask WHERE task_Date<strftime('%d-%m-%Y','now') ORDER BY task_Date")
    LiveData<List<ItemTask>> getOverdueTask();

    @Insert
    void insertTask(ItemTask itemTask);

    @Update
    void updateTask(ItemTask itemTask);

}
