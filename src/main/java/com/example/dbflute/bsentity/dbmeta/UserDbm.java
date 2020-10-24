package com.example.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.example.dbflute.allcommon.*;
import com.example.dbflute.exentity.*;

/**
 * The DB meta of user. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class UserDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final UserDbm _instance = new UserDbm();
    private UserDbm() {}
    public static UserDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((User)et).getId(), (et, vl) -> ((User)et).setId(cti(vl)), "id");
        setupEpg(_epgMap, et -> ((User)et).getName(), (et, vl) -> ((User)et).setName((String)vl), "name");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "user";
    protected final String _tableDispName = "user";
    protected final String _tablePropertyName = "user";
    protected final TableSqlName _tableSqlName = new TableSqlName("user", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, Integer.class, "id", null, true, true, true, "INT", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, String.class, "name", null, false, false, false, "VARCHAR", 100, 0, null, null, false, null, null, null, null, null, false);

    /**
     * id: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnId() { return _columnId; }
    /**
     * name: {VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnName() { return _columnName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.exentity.User"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cbean.UserCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.exbhv.UserBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<User> getEntityType() { return User.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public User newEntity() { return new User(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((User)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((User)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
