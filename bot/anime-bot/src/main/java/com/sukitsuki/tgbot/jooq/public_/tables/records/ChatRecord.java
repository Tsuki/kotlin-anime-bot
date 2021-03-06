/*
 * This file is generated by jOOQ.
*/
package com.sukitsuki.tgbot.jooq.public_.tables.records;


import com.sukitsuki.tgbot.jooq.public_.tables.Chat;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ChatRecord extends UpdatableRecordImpl<ChatRecord> implements Record5<Integer, Integer, String, String, String> {

    private static final long serialVersionUID = -83723802;

    /**
     * Setter for <code>PUBLIC.CHAT.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.CHAT.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.CHAT.CHATID</code>.
     */
    public void setChatid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.CHAT.CHATID</code>.
     */
    public Integer getChatid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>PUBLIC.CHAT.NAME</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.CHAT.NAME</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.CHAT.LOCALE</code>.
     */
    public void setLocale(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.CHAT.LOCALE</code>.
     */
    public String getLocale() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.CHAT.TYPE</code>.
     */
    public void setType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.CHAT.TYPE</code>.
     */
    public String getType() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Chat.CHAT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Chat.CHAT.CHATID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Chat.CHAT.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Chat.CHAT.LOCALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Chat.CHAT.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getChatid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLocale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord value2(Integer value) {
        setChatid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord value4(String value) {
        setLocale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord value5(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRecord values(Integer value1, Integer value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatRecord
     */
    public ChatRecord() {
        super(Chat.CHAT);
    }

    /**
     * Create a detached, initialised ChatRecord
     */
    public ChatRecord(Integer id, Integer chatid, String name, String locale, String type) {
        super(Chat.CHAT);

        set(0, id);
        set(1, chatid);
        set(2, name);
        set(3, locale);
        set(4, type);
    }
}
