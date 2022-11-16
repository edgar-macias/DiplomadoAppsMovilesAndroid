package mx.emp.primerproyecto.actividad_tres.services

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mx.emp.primerproyecto.actividad_tres.models.AnimalSqlModel

class AnimalDBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "animals.db"
        private const val DATABASE_VERSION = 1
        private const val TBL_ANIMAL = "animal"
    }

    override fun onCreate(database: SQLiteDatabase?) {
        //Se utiliza el iso/iec 5218 para determinar el sexo|genero del animal
        val animalTableQuery = "CREATE TABLE animal (" +
                "id integer primary key autoincrement," +
                "name text not null, description text," +
                "url_image text not null," +
                "gender text check(gender in ('M','F','S'))," +
                "is_sick integer check(is_sick in (0,1)))"

        database?.execSQL(animalTableQuery)
    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
        val sqlUpdate = "DROP TABLE IF EXISTS animal"
        database?.execSQL(sqlUpdate)
        onCreate(database)
    }

    fun insert(animal : AnimalSqlModel) : Long{
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put("name", animal.name)
            put("description", animal.description)
            put("url_image", animal.url_image)
            put("gender", animal.gender)
            put("is_sick", animal.is_sick)
        }

        val result = db.insert(TBL_ANIMAL, null, contentValues)
        db.close()
        return result
    }

    fun updateUser(animal : AnimalSqlModel) : Int{
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put("id",animal.id)
            put("name", animal.name)
            put("description", animal.description)
            put("url_image", animal.url_image)
            put("gender", animal.gender)
            put("is_sick", animal.is_sick)
        }

        val result = db.update(TBL_ANIMAL, contentValues,"id=?", arrayOf("${animal.id}"))
        db.close()
        return result
    }

    fun deleteUser(animalId: Int) : Int{
        val db = writableDatabase
        val result = db.delete(TBL_ANIMAL, "id=?", arrayOf("$animalId"))
        db.close()
        return result
    }

    fun getAllAnimals():ArrayList<AnimalSqlModel>{
        val animalList = arrayListOf<AnimalSqlModel>()
        val query = "SELECT * FROM $TBL_ANIMAL"
        val db = readableDatabase
        val cursor : Cursor?

        try {
            cursor = db.rawQuery(query, null)
        }catch (e: Exception){
            e.printStackTrace()
            return animalList
        }

        var id : Int
        var name : String
        var description : String
        var urlImage:String
        var gender:String?
        var isSick:Int?

        with(cursor){
            while (moveToNext()) {
                id = getInt(getColumnIndexOrThrow("id"))
                name = getString(getColumnIndexOrThrow("name"))
                description = getString(getColumnIndexOrThrow("description"))
                urlImage = getString(getColumnIndexOrThrow("url_image"))
                gender = getString(getColumnIndexOrThrow("gender"))
                isSick = getInt(getColumnIndexOrThrow("is_sick"))

                val animal = AnimalSqlModel(id, name, description,urlImage,gender,isSick)
                animalList.add(animal)
            }
        }
        cursor.close()
//        id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
//        name = cursor.getString(cursor.getColumnIndexOrThrow(NAME))
//        description = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION))
        return animalList
    }
}