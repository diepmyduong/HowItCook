package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 23/12/2015.
 */
public class StuffDAL {
    private List<Stuff> _stuff;

    public StuffDAL(){
        _stuff = new ArrayList<Stuff>();

        _stuff.add(new Stuff(1,1,1,"Cá điêu hồng: 1 con"));
        _stuff.add(new Stuff(2,1,2,"Gia vị hoàn chỉnh Barona vị canh chua nam bộ : 1 gói"));
        _stuff.add(new Stuff(3,1,3,"Măng chua: 200gr"));
        _stuff.add(new Stuff(4,1,4,"Ớt sừng: 1 trái"));
        _stuff.add(new Stuff(5,1,5,"Me: 50gr"));
        _stuff.add(new Stuff(6,1,6,"Ngò gai: 20gr"));
        _stuff.add(new Stuff(7,1,7,"Ngò ôm: 20gr"));
        _stuff.add(new Stuff(8,1,8,"Cà chua: 4 quả"));
        _stuff.add(new Stuff(9,1,9,"Tỏi củ: 1 củ"));
        _stuff.add(new Stuff(10,1,10,"Hành tím: 1 củ"));
        _stuff.add(new Stuff(11,1,11,"Đường: 1 muỗng"));
        _stuff.add(new Stuff(12,1,12,"Ớt hiểm : 2 trái"));
    }


    public List<Stuff> getAllList(){
        return _stuff;
    }

    public Stuff findById(int id){
        for (Stuff stuff:_stuff) {
            if(stuff.get_id() == id){
                return stuff;
            }
        }
        return  null;
    }

    public List<Stuff> findByCourse(int id){
        List<Stuff> result = new ArrayList<>();
        for(Stuff stuff:_stuff){
            if(stuff.get_courseID() == id){
                result.add(stuff);
            }
        }
        //Sort by rank
        Collections.sort(result,new Comparator<Stuff>() {
            public int compare(Stuff self, Stuff other) {
                // I'm assuming your Employee.id is an Integer not an int.
                // If you'd like to use int, create an Integer before calling compareTo.
                if (self.get_rank() > other.get_rank()) {
                    return 1;
                } else if (self.get_rank() < other.get_rank()) {
                    return -1;
                }
                return 0;
            }
        });
        return result;
    }
}
