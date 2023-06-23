package daopattern;

import model.Room;

import java.util.ArrayList;






public interface IRespository<R> {
    ArrayList<R> getAll();
    Boolean create (R r);
    Boolean editRoom(R r);
    Room find(Integer id);
    Boolean deleteRoom(R r);


}


