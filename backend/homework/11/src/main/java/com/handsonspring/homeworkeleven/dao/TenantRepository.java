package com.handsonspring.homeworkeleven.dao;

import com.handsonspring.homeworkeleven.entity.Shift;
import com.handsonspring.homeworkeleven.entity.ShiftTypes;
import com.handsonspring.homeworkeleven.entity.Users;
import com.handsonspring.homeworkeleven.exceptions.ErrorWhileExecutingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public class TenantRepository {
    private JdbcTemplate jdbcTemplate ;
    @Autowired
    public TenantRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addTenant(String name,String email){
        try {
            String sql = "INSERT INTO tenant(name,email) values (?,?)";
            jdbcTemplate.update(sql, name, email);
            String selectSql = "SELECT id FROM tenant WHERE name = ? AND email = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{name, email}, String.class);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error while adding tenant");
        }
    }

    /**
     *
     * @param shiftTypeName
     * @param description
     * @param tenantId
     * @return
     */

    public String addShiftType(String shiftTypeName,String description,String tenantId){
        try {
            String sql = "INSERT INTO shift_types(uq_name,description,tenant_id) values (?,?,?)";
            UUID tenantUUID = UUID.fromString(tenantId);
            jdbcTemplate.update(sql, shiftTypeName, description, tenantUUID);

            String selectSql = "SELECT id FROM shift_types WHERE uq_name = ? AND tenant_id = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{shiftTypeName, tenantUUID}, String.class);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error while adding to shift type");
        }
    }

    /**
     *
     * @param shift
     * @param tenantId
     * @param shiftTypeId
     * @return
     */

    public String addShift(Shift shift,String tenantId,String shiftTypeId){
        try {
            String sql = "INSERT INTO shifts(shift_type_id,name,date_start,date_end,time_start,time_end,tenant_id) values(?,?,?,?,?,?,?)";
            UUID tenantUUID = UUID.fromString(tenantId);
            UUID shiftTypeUUID = UUID.fromString(shiftTypeId);


            jdbcTemplate.update(sql, shiftTypeUUID, shift.getShiftName(), shift.getDateStart(), shift.getDateEnd(), shift.getTimeStart(), shift.getTimeEnd(), tenantUUID);

            String selectSql = "SELECT id from shifts where shift_type_id = ? and tenant_id = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{shiftTypeUUID, tenantUUID}, String.class);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error while inserting into shift");
        }
    }

    /**
     *
     * @param users
     * @param tenantId
     * @return
     */

    public String addUsers(Users users,String tenantId){
        try {
            String sql = "INSERT INTO users(username,loggedin,tenant_id) values(?,?,?)";
            UUID tenantIdUUID = UUID.fromString(tenantId);

            jdbcTemplate.update(sql, users.getUserName(), users.getLoggedIn(), tenantIdUUID);

            String selectSql = "SELECT id from users where username = ? and tenant_id = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{users.getUserName(), tenantIdUUID}, String.class);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error while adding user");
        }
    }

    /**
     *
     * @param shiftId
     * @param userId
     * @param tenantId
     * @return
     */
    public String addshiftUser(String shiftId,String userId,String tenantId){
        try {
            String sql = "INSERT INTO shift_user(shift_id,user_id,tenant_id) values (?,?,?)";
            UUID shiftIdUUID = UUID.fromString(shiftId);
            UUID userIdUUID = UUID.fromString(userId);
            UUID tenantIDUUID = UUID.fromString(tenantId);
            jdbcTemplate.update(sql, shiftIdUUID, userIdUUID, tenantIDUUID);

            String selectSql = "SELECT id from shift_user where shift_id = ? and user_id = ? and tenant_id = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{shiftIdUUID, userIdUUID, tenantIDUUID}, String.class);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error while adding into shift user");
        }
    }

    /**
     *
     * @param username
     * @param tenantId
     * @return
     */

    public String updateUser(String username,String tenantId){
        try {
            String sql = "UPDATE users set username = ? where tenant_id = ?";
            UUID tenantIdUUID = UUID.fromString(tenantId);

            jdbcTemplate.update(sql, username, tenantIdUUID);
            String selectSql = "SELECT id from users where username = ? and id = ?";
            return jdbcTemplate.queryForObject(selectSql, new Object[]{selectSql, username, tenantIdUUID}, String.class);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while updating user");
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public ShiftTypes getShift(String id){
        try{
            String sql ="SELECT description from shift_types where id = '?'";
            return jdbcTemplate.queryForObject(sql,new Object[]{UUID.fromString(id)}, ShiftTypes.class);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while getting shift_types");
        }
    }
}
