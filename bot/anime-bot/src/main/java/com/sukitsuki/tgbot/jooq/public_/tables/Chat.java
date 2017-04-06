/*
 * This file is generated by jOOQ.
*/
package com.sukitsuki.tgbot.jooq.public_.tables;


import com.sukitsuki.tgbot.jooq.public_.Keys;
import com.sukitsuki.tgbot.jooq.public_.Public;
import com.sukitsuki.tgbot.jooq.public_.tables.records.ChatRecord;

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
public class Chat extends TableImpl<ChatRecord> {

    private static final long serialVersionUID = 212931258;

    /**
     * The reference instance of <code>PUBLIC.CHAT</code>
     */
    public static final Chat CHAT = new Chat();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChatRecord> getRecordType() {
        return ChatRecord.class;
    }

    /**
     * The column <code>PUBLIC.CHAT.ID</code>.
     */
    public final TableField<ChatRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_62E81A94_5029_4514_B434_D015856DA09E)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>PUBLIC.CHAT.CHATID</code>.
     */
    public final TableField<ChatRecord, Integer> CHATID = createField("CHATID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CHAT.NAME</code>.
     */
    public final TableField<ChatRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.CHAT.LOCALE</code>.
     */
    public final TableField<ChatRecord, String> LOCALE = createField("LOCALE", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * Create a <code>PUBLIC.CHAT</code> table reference
     */
    public Chat() {
        this("CHAT", null);
    }

    /**
     * Create an aliased <code>PUBLIC.CHAT</code> table reference
     */
    public Chat(String alias) {
        this(alias, CHAT);
    }

    private Chat(String alias, Table<ChatRecord> aliased) {
        this(alias, aliased, null);
    }

    private Chat(String alias, Table<ChatRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ChatRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CHAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ChatRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ChatRecord>> getKeys() {
        return Arrays.<UniqueKey<ChatRecord>>asList(Keys.CONSTRAINT_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Chat as(String alias) {
        return new Chat(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Chat rename(String name) {
        return new Chat(name, null);
    }
}
