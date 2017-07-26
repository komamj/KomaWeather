package com.koma.weather.data.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.koma.weather.data.model.SuggestionInfo.BaseInfo;
import com.koma.weather.util.BaseInfoConverter;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "suggestion_info".
*/
public class SuggestionInfoDao extends AbstractDao<SuggestionInfo, Long> {

    public static final String TABLENAME = "suggestion_info";

    /**
     * Properties of entity SuggestionInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ComforInfo = new Property(1, String.class, "comforInfo", false, "COMFOR_INFO");
        public final static Property CarWashInfo = new Property(2, String.class, "carWashInfo", false, "CAR_WASH_INFO");
        public final static Property DressInfo = new Property(3, String.class, "dressInfo", false, "DRESS_INFO");
        public final static Property ColdInfo = new Property(4, String.class, "coldInfo", false, "COLD_INFO");
        public final static Property SportInfo = new Property(5, String.class, "sportInfo", false, "SPORT_INFO");
        public final static Property TravelInfo = new Property(6, String.class, "travelInfo", false, "TRAVEL_INFO");
        public final static Property UltravioletInfo = new Property(7, String.class, "ultravioletInfo", false, "ULTRAVIOLET_INFO");
    }

    private final BaseInfoConverter comforInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter carWashInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter dressInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter coldInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter sportInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter travelInfoConverter = new BaseInfoConverter();
    private final BaseInfoConverter ultravioletInfoConverter = new BaseInfoConverter();

    public SuggestionInfoDao(DaoConfig config) {
        super(config);
    }
    
    public SuggestionInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"suggestion_info\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"COMFOR_INFO\" TEXT," + // 1: comforInfo
                "\"CAR_WASH_INFO\" TEXT," + // 2: carWashInfo
                "\"DRESS_INFO\" TEXT," + // 3: dressInfo
                "\"COLD_INFO\" TEXT," + // 4: coldInfo
                "\"SPORT_INFO\" TEXT," + // 5: sportInfo
                "\"TRAVEL_INFO\" TEXT," + // 6: travelInfo
                "\"ULTRAVIOLET_INFO\" TEXT);"); // 7: ultravioletInfo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"suggestion_info\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SuggestionInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        BaseInfo comforInfo = entity.getComforInfo();
        if (comforInfo != null) {
            stmt.bindString(2, comforInfoConverter.convertToDatabaseValue(comforInfo));
        }
 
        BaseInfo carWashInfo = entity.getCarWashInfo();
        if (carWashInfo != null) {
            stmt.bindString(3, carWashInfoConverter.convertToDatabaseValue(carWashInfo));
        }
 
        BaseInfo dressInfo = entity.getDressInfo();
        if (dressInfo != null) {
            stmt.bindString(4, dressInfoConverter.convertToDatabaseValue(dressInfo));
        }
 
        BaseInfo coldInfo = entity.getColdInfo();
        if (coldInfo != null) {
            stmt.bindString(5, coldInfoConverter.convertToDatabaseValue(coldInfo));
        }
 
        BaseInfo sportInfo = entity.getSportInfo();
        if (sportInfo != null) {
            stmt.bindString(6, sportInfoConverter.convertToDatabaseValue(sportInfo));
        }
 
        BaseInfo travelInfo = entity.getTravelInfo();
        if (travelInfo != null) {
            stmt.bindString(7, travelInfoConverter.convertToDatabaseValue(travelInfo));
        }
 
        BaseInfo ultravioletInfo = entity.getUltravioletInfo();
        if (ultravioletInfo != null) {
            stmt.bindString(8, ultravioletInfoConverter.convertToDatabaseValue(ultravioletInfo));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SuggestionInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        BaseInfo comforInfo = entity.getComforInfo();
        if (comforInfo != null) {
            stmt.bindString(2, comforInfoConverter.convertToDatabaseValue(comforInfo));
        }
 
        BaseInfo carWashInfo = entity.getCarWashInfo();
        if (carWashInfo != null) {
            stmt.bindString(3, carWashInfoConverter.convertToDatabaseValue(carWashInfo));
        }
 
        BaseInfo dressInfo = entity.getDressInfo();
        if (dressInfo != null) {
            stmt.bindString(4, dressInfoConverter.convertToDatabaseValue(dressInfo));
        }
 
        BaseInfo coldInfo = entity.getColdInfo();
        if (coldInfo != null) {
            stmt.bindString(5, coldInfoConverter.convertToDatabaseValue(coldInfo));
        }
 
        BaseInfo sportInfo = entity.getSportInfo();
        if (sportInfo != null) {
            stmt.bindString(6, sportInfoConverter.convertToDatabaseValue(sportInfo));
        }
 
        BaseInfo travelInfo = entity.getTravelInfo();
        if (travelInfo != null) {
            stmt.bindString(7, travelInfoConverter.convertToDatabaseValue(travelInfo));
        }
 
        BaseInfo ultravioletInfo = entity.getUltravioletInfo();
        if (ultravioletInfo != null) {
            stmt.bindString(8, ultravioletInfoConverter.convertToDatabaseValue(ultravioletInfo));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SuggestionInfo readEntity(Cursor cursor, int offset) {
        SuggestionInfo entity = new SuggestionInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : comforInfoConverter.convertToEntityProperty(cursor.getString(offset + 1)), // comforInfo
            cursor.isNull(offset + 2) ? null : carWashInfoConverter.convertToEntityProperty(cursor.getString(offset + 2)), // carWashInfo
            cursor.isNull(offset + 3) ? null : dressInfoConverter.convertToEntityProperty(cursor.getString(offset + 3)), // dressInfo
            cursor.isNull(offset + 4) ? null : coldInfoConverter.convertToEntityProperty(cursor.getString(offset + 4)), // coldInfo
            cursor.isNull(offset + 5) ? null : sportInfoConverter.convertToEntityProperty(cursor.getString(offset + 5)), // sportInfo
            cursor.isNull(offset + 6) ? null : travelInfoConverter.convertToEntityProperty(cursor.getString(offset + 6)), // travelInfo
            cursor.isNull(offset + 7) ? null : ultravioletInfoConverter.convertToEntityProperty(cursor.getString(offset + 7)) // ultravioletInfo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SuggestionInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setComforInfo(cursor.isNull(offset + 1) ? null : comforInfoConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setCarWashInfo(cursor.isNull(offset + 2) ? null : carWashInfoConverter.convertToEntityProperty(cursor.getString(offset + 2)));
        entity.setDressInfo(cursor.isNull(offset + 3) ? null : dressInfoConverter.convertToEntityProperty(cursor.getString(offset + 3)));
        entity.setColdInfo(cursor.isNull(offset + 4) ? null : coldInfoConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setSportInfo(cursor.isNull(offset + 5) ? null : sportInfoConverter.convertToEntityProperty(cursor.getString(offset + 5)));
        entity.setTravelInfo(cursor.isNull(offset + 6) ? null : travelInfoConverter.convertToEntityProperty(cursor.getString(offset + 6)));
        entity.setUltravioletInfo(cursor.isNull(offset + 7) ? null : ultravioletInfoConverter.convertToEntityProperty(cursor.getString(offset + 7)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SuggestionInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SuggestionInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SuggestionInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}