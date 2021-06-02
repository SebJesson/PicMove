package com.jvziyaoyao.picmove.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jvziyaoyao.picmove.domain.entity.PhotoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PM_PHOTO".
*/
public class PhotoEntityDao extends AbstractDao<PhotoEntity, Long> {

    public static final String TABLENAME = "PM_PHOTO";

    /**
     * Properties of entity PhotoEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property Path = new Property(1, String.class, "path", false, "PATH");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Size = new Property(3, long.class, "size", false, "SIZE");
        public final static Property Time = new Property(4, long.class, "time", false, "TIME");
    }


    public PhotoEntityDao(DaoConfig config) {
        super(config);
    }
    
    public PhotoEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PM_PHOTO\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"PATH\" TEXT UNIQUE ," + // 1: path
                "\"NAME\" TEXT," + // 2: name
                "\"SIZE\" INTEGER NOT NULL ," + // 3: size
                "\"TIME\" INTEGER NOT NULL );"); // 4: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PM_PHOTO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PhotoEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(2, path);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        stmt.bindLong(4, entity.getSize());
        stmt.bindLong(5, entity.getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PhotoEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(2, path);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        stmt.bindLong(4, entity.getSize());
        stmt.bindLong(5, entity.getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public PhotoEntity readEntity(Cursor cursor, int offset) {
        PhotoEntity entity = new PhotoEntity( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // path
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.getLong(offset + 3), // size
            cursor.getLong(offset + 4) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PhotoEntity entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setPath(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSize(cursor.getLong(offset + 3));
        entity.setTime(cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PhotoEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PhotoEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PhotoEntity entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
