package OpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    String query="Create table usuarios (_ID integer primary key autoincrement," +
            " Nombre text, Ciudad text,Correo text,Password text);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }


    public  void cerrar(){
        this.close();
        }




//        Insertar Registros en Tabla Usuarios

    public void insertarReg(String nom, String ciu,String cor,String pas){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Ciudad",ciu);
        valores.put("Correo",cor);
        valores.put("Password",pas);

        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    public Cursor ConsultarUsuPas (String usu,String pas) throws SQLException{
        Cursor mcursor=null;
      
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Ciudad","Correo","Password"},"Correo like'"+usu+"'and Password like'"+pas+"'",null,null,null,null);
        return mcursor;

    }


























}
