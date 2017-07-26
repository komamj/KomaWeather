package com.koma.weather.data.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.koma.weather.util.ConditionInfoConverter;
import com.koma.weather.util.WindInfoConverter;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "hourly_forecast".
*/
public class HourlyForecastInfoDao extends AbstractDao<HourlyForecastInfo, Long> {

    public static final String TABLENAME = "hourly_forecast";

    /**
     * Properties of entity HourlyForecastInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MHumidity = new Property(1, String.class, "mHumidity", false, "hum");
        public final static Property MPcpnProbability = new Property(2, String.class, "mPcpnProbability", false, "pop");
        public final static Property MAirPressure = new Property(3, String.class, "mAirPressure", false, "pres");
        public final static Property MWindInfo = new Property(4, String.class, "mWindInfo", false, "wind");
        public final static Property MConditionInfo = new Property(5, String.class, "mConditionInfo", false, "M_CONDITION_INFO");
        public final static Property MDate = new Property(6, String.class, "mDate", false, "date");
        public final static Property MTemperature = new Property(7, String.class, "mTemperature", false, "tmp");
    }

    private final WindInfoConverter mWindInfoConverter = new WindInfoConverter();
    private final ConditionInfoConverter mConditionInfoConverter = new ConditionInfoConverter();

    public HourlyForecastInfoDao(DaoConfig config) {
        super(config);
    }
    
    public HourlyForecastInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"hourly_forecast\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"hum\" TEXT," + // 1: mHumidity
                "\"pop\" TEXT," + // 2: mPcpnProbability
                "\"pres\" TEXT," + // 3: mAirPressure
                "\"wind\" TEXT," + // 4: mWindInfo
                "\"M_CONDITION_INFO\" TEXT," + // 5: mConditionInfo
                "\"date\" TEXT," + // 6: mDate
                "\"tmp\" TEXT);"); // 7: mTemperature
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"hourly_forecast\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HourlyForecastInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mHumidity = entity.getMHumidity();
        if (mHumidity != null) {
            stmt.bindString(2, mHumidity);
        }
 
        String mPcpnProbability = entity.getMPcpnProbability();
        if (mPcpnProbability != null) {
            stmt.bindString(3, mPcpnProbability);
        }
 
        String mAirPressure = entity.getMAirPressure();
        if (mAirPressure != null) {
            stmt.bindString(4, mAirPressure);
        }
 
        WindInfo mWindInfo = entity.getMWindInfo();
        if (mWindInfo != null) {
            stmt.bindString(5, mWindInfoConverter.convertToDatabaseValue(mWindInfo));
        }
 
        ConditionInfo mConditionInfo = entity.getMConditionInfo();
        if (mConditionInfo != null) {
            stmt.bindString(6, mConditionInfoConverter.convertToDatabaseValue(mConditionInfo));
        }
 
        String mDate = entity.getMDate();
        if (mDate != null) {
            stmt.bindString(7, mDate);
        }
 
        String mTemperature = entity.getMTemperature();
        if (mTemperature != null) {
            stmt.bindString(8, mTemperature);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HourlyForecastInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mHumidity = entity.getMHumidity();
        if (mHumidity != null) {
            stmt.bindString(2, mHumidity);
        }
 
        String mPcpnProbability = entity.getMPcpnProbability();
        if (mPcpnProbability != null) {
            stmt.bindString(3, mPcpnProbability);
        }
 
        String mAirPressure = entity.getMAirPressure();
        if (mAirPressure != null) {
            stmt.bindString(4, mAirPressure);
        }
 
        WindInfo mWindInfo = entity.getMWindInfo();
        if (mWindInfo != null) {
            stmt.bindString(5, mWindInfoConverter.convertToDatabaseValue(mWindInfo));
        }
 
        ConditionInfo mConditionInfo = entity.getMConditionInfo();
        if (mConditionInfo != null) {
            stmt.bindString(6, mConditionInfoConverter.convertToDatabaseValue(mConditionInfo));
        }
 
        String mDate = entity.getMDate();
        if (mDate != null) {
            stmt.bindString(7, mDate);
        }
 
        String mTemperature = entity.getMTemperature();
        if (mTemperature != null) {
            stmt.bindString(8, mTemperature);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HourlyForecastInfo readEntity(Cursor cursor, int offset) {
        HourlyForecastInfo entity = new HourlyForecastInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // mHumidity
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mPcpnProbability
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mAirPressure
            cursor.isNull(offset + 4) ? null : mWindInfoConverter.convertToEntityProperty(cursor.getString(offset + 4)), // mWindInfo
            cursor.isNull(offset + 5) ? null : mConditionInfoConverter.convertToEntityProperty(cursor.getString(offset + 5)), // mConditionInfo
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mDate
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // mTemperature
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HourlyForecastInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMHumidity(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMPcpnProbability(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMAirPressure(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMWindInfo(cursor.isNull(offset + 4) ? null : mWindInfoConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setMConditionInfo(cursor.isNull(offset + 5) ? null : mConditionInfoConverter.convertToEntityProperty(cursor.getString(offset + 5)));
        entity.setMDate(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMTemperature(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HourlyForecastInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HourlyForecastInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HourlyForecastInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
