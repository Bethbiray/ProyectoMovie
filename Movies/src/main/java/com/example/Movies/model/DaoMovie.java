package com.example.Movies.model;

import com.example.Movies.service.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMovie {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanMovie> findAll(){
        List<BeanMovie> listMovie = new ArrayList<>();
        try {

            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanMovie movie = new BeanMovie();
                movie.setId(rs.getInt("id"));
                movie.setName(rs.getString("name"));
                movie.setDescription(rs.getString("description"));
                movie.setDate_premiere(rs.getString("date_premiere"));
                movie.setCollection(rs.getDouble("collection"));
                movie.setStatus(rs.getInt("status"));


                listMovie.add(movie);
            }
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listMovie;
    }

    public BeanMovie findById(int id){
        BeanMovie movie = null;
        try {

            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findById(?)}");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                movie=new BeanMovie();
                movie.setId(rs.getInt("id"));
                movie.setName(rs.getString("name"));
                movie.setDescription(rs.getString("description"));
                movie.setDate_premiere(rs.getString("date_premiere"));
                movie.setCollection(rs.getDouble("collection"));
                movie.setStatus(rs.getInt("status"));

            }
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return movie;
    }

    public boolean create(BeanMovie movie){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, movie.getName());
            cstm.setString(2, movie.getDescription());
            cstm.setString(3, movie.getDate_premiere());
            cstm.setDouble(4, movie.getCollection());

            cstm.execute();
            flag = true;
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }


    public boolean update(BeanMovie movie){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?)}");
            cstm.setInt(1, movie.getId());
            cstm.setString(2, movie.getName());
            cstm.setString(3, movie.getDescription());
            cstm.setString(4, movie.getDate_premiere());
            cstm.setDouble(5, movie.getCollection());


            flag = cstm.execute();
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int id){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setLong(1, id);

            flag = cstm.execute();
        }catch(SQLException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

}
