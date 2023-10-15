package com.example.musiceventsystem.datasource;

import com.example.musiceventsystem.util.JDBCUtil;
import com.example.musiceventsystem.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UnitOfWork {
    private static final ThreadLocal<UnitOfWork> current = new ThreadLocal<>();
    private final List<Object> newObjects = new ArrayList<>();
    private final List<Object> dirtyObjects = new ArrayList<>();
    private final List<Object> deletedObjects = new ArrayList<>();

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    public static void setCurrent(UnitOfWork uow) {
        current.set(uow);
    }

    public static UnitOfWork getCurrent() {
        return current.get();
    }

    public void registerNew(Object obj) {
        assert !dirtyObjects.contains(obj);
        assert !deletedObjects.contains(obj);
        newObjects.add(obj);
    }

    public void registerDirty(Object obj) {
        assert !deletedObjects.contains(obj);
        if (!dirtyObjects.contains(obj)) {
            dirtyObjects.add(obj);
        }
    }

    public void registerDeleted(Object obj) {
        if (newObjects.remove(obj)) return;
        dirtyObjects.remove(obj);
        if (!deletedObjects.contains(obj)) {
            deletedObjects.add(obj);
        }
    }

    public void commit() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            EventMapper eventMapper = new EventMapper();
            CustomerMapper customerMapper = new CustomerMapper();

            for (Object obj : newObjects) {
                if (obj instanceof Event) {
                    Integer eventId = eventMapper.save((Event) obj);
                    if(eventId < 0){
                        throw new RuntimeException("Event creation failure!");
                    };
                } else if (obj instanceof Customer) {
                    Integer save = customerMapper.save((Customer) obj);
                    if(save != 1) throw new RuntimeException("Customer creation failure!");
                }
                // Add more conditions for other types
            }

            for (Object obj : dirtyObjects) {
                if (obj instanceof Event) {
                    int update = eventMapper.update((Event) obj);
                    if(update != 1) throw new RuntimeException("Event edit failure!");
                } else if (obj instanceof Customer) {
                    int update = customerMapper.update((Customer) obj);
                    if(update != 1) throw new RuntimeException("Customer edit failure!");
                }
                // Add more conditions for other types
            }

            for (Object obj : deletedObjects) {
                if (obj instanceof Event) {
                    eventMapper.delete(((Event) obj).getId());
                } else if (obj instanceof Customer) {
                    customerMapper.delete(((Customer) obj).getId());
                }
                // Add more conditions for other types
            }

            connection.commit();  // commit the transaction

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();  // rollback transaction on exception
                }
            } catch (SQLException re) {
                // Log the failure to rollback
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);  // restore default setting
                    JDBCUtil.release(connection, null, null);
                }
            } catch (SQLException e) {
                // Log the failure to set AutoCommit
            }

            // Clear registered objects
            newObjects.clear();
            dirtyObjects.clear();
            deletedObjects.clear();
        }
    }


}

