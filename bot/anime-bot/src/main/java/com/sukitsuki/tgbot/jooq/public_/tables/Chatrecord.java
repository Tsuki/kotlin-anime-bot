/*
 * This file is generated by jOOQ.
*/
package com.sukitsuki.tgbot.jooq.public_.tables;


import com.sukitsuki.tgbot.jooq.public_.Keys;
import com.sukitsuki.tgbot.jooq.public_.Public;
import com.sukitsuki.tgbot.jooq.public_.tables.records.ChatrecordRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Chatrecord extends TableImpl<ChatrecordRecord> {

    private static final long serialVersionUID = -2060250241;

    /**
     * The reference instance of <code>PUBLIC.CHATRECORD</code>
     */
    public static final Chatrecord CHATRECORD = new Chatrecord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChatrecordRecord> getRecordType() {
        return ChatrecordRecord.class;
    }

    /**
     * The column <code>PUBLIC.CHATRECORD.ID</code>.
     */
    public final TableField<ChatrecordRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_46470562_D2B1_4D58_99B1_BDA8502CF105)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>PUBLIC.CHATRECORD.CHATID</code>.
     */
    public final TableField<ChatrecordRecord, Integer> CHATID = createField("CHATID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CHATRECORD.NAME</code>.
     */
    public final TableField<ChatrecordRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>PUBLIC.CHATRECORD.LOCALE</code>.
     */
    public final TableField<ChatrecordRecord, String> LOCALE = createField("LOCALE", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * Create a <code>PUBLIC.CHATRECORD</code> table reference
     */
    public Chatrecord() {
        this("CHATRECORD", null);
    }

    /**
     * Create an aliased <code>PUBLIC.CHATRECORD</code> table reference
     */
    public Chatrecord(String alias) {
        this(alias, CHATRECORD);
    }

    private Chatrecord(String alias, Table<ChatrecordRecord> aliased) {
        this(alias, aliased, null);
    }

    private Chatrecord(String alias, Table<ChatrecordRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ChatrecordRecord, Long> getIdentity() {
        return Keys.IDENTITY_CHATRECORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ChatrecordRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_BB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ChatrecordRecord>> getKeys() {
        return Arrays.<UniqueKey<ChatrecordRecord>>asList(Keys.CONSTRAINT_BB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Chatrecord as(String alias) {
        return new Chatrecord(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Chatrecord rename(String name) {
        return new Chatrecord(name, null);
    }
}
