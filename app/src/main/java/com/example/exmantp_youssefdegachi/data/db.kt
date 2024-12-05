package com.example.exmantp_youssefdegachi.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.exmantp_youssefdegachi.data.model.Car

class Database(context: Context) : SQLiteOpenHelper(context, "cars.db", null, 1) {

    // Create table for cars
    override fun onCreate(db: SQLiteDatabase) {
        val createTableSQL = """
            CREATE TABLE cars (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                mark TEXT,
                price REAL,
                description TEXT
            )
        """
        db.execSQL(createTableSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    // Insert a new car
    fun insertCar(car: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", car.name)
            put("mark",car.mark)
            put("price", car.price)
            put("description", car.description)
        }
        db.insert("cars", null, values)
        db.close()
    }

    // Get all cars
    fun getAllCars(): List<Car> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM cars", null)
        val carList = mutableListOf<Car>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val mark = cursor.getString(2)
            val price = cursor.getDouble(3)
            val description = cursor.getString(4)
            val car = Car(id, name, mark, price.toString(), description)
            carList.add(car)
        }
        cursor.close()
        db.close()
        return carList
    }

    // Delete a car by ID
    fun deleteCar(id: Int) {
        val db = writableDatabase
        db.delete("cars", "id = ?", arrayOf(id.toString()))
        db.close()
    }

    // Update a car's details
    fun updateCar(car: Car) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", car.name)
            put("mark",car.mark)
            put("price", car.price)
            put("description", car.description)
        }
        db.update("cars", values, "id = ?", arrayOf(car.id.toString()))
        db.close()
    }


    }
}