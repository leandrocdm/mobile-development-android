package br.com.fiap.app_persistence_ii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MeuDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MeuDB";
    public static final int VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    SQLiteDatabase dbWrite = getWritableDatabase();
    SQLiteDatabase dbRead = getReadableDatabase();

    ContentValues cv = new ContentValues();

    public MeuDB(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TB_CLIENTE + " (`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome`TEXT NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirCliente(Cliente cliente) {

        cv.put("nome", cliente.getNome());
        dbWrite.insert(TB_CLIENTE, null, cv);

    }

    public void atualizaCliente(Cliente cliente) {

        cv.put("id", cliente.getId());
        cv.put("nome", cliente.getNome());

        dbWrite.update(
                TB_CLIENTE,
                cv,
                "id=?",
                new String[]{String.valueOf(cliente.getId())}
        );
    }

    public void deletarCliente(int id) {
        dbWrite.delete(
                TB_CLIENTE,
                "id=?",
                new String[]{String.valueOf(id)});
    }

    public List<Cliente> getCliente() {
        List<Cliente> clientes = new ArrayList<>();

        Cursor cursor = dbRead.query(
                TB_CLIENTE,
                new String[]{"id", "nome"},
                null,
                null,
                null,
                null,
                "nome ASC"
        );

        while (cursor.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(0));
            cliente.setNome(cursor.getString(1));

            clientes.add(cliente);
        }

        return clientes;
    }
}
