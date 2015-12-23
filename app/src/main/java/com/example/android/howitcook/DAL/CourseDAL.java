package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 12/12/2015.
 */
public class CourseDAL {

    private List<Course> _course;

    public CourseDAL(){
        _course = new ArrayList<>();
        
        _course.add(new Course(1,"Fonda Hussman","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",6));
        _course.add(new Course(2,"Candance Greensfelder","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",6));
        _course.add(new Course(3,"Shelby Fuss","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",7));
        _course.add(new Course(4,"Phylis Gerthung","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",9));
        _course.add(new Course(5,"Lamonica Leva","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",9));
        _course.add(new Course(6,"Emmaline Sahni","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",6));
        _course.add(new Course(7,"Arvilla Foreback","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",9));
        _course.add(new Course(8,"Boris Dino","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",8));
        _course.add(new Course(9,"Roberto Cherwinski","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",8));
        _course.add(new Course(10,"Maile Javers","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum maiores in voluptatibus et, similique ipsam eligendi esse dolor nam provident.","categories_1",9));
    }

    public List<Course> getAllList(){
        return _course;
    }

    public Course findById(int id){
        for (Course course:_course) {
            if(course.get_id() == id){
                return course;
            }
        }
        return  null;
    }

    public List<Course> findByCatelory(int id){
        List<Course> result = new ArrayList<>();
        for(Course course:_course){
            if(course.get_categoryID() == id){
                result.add(course);
            }
        }
        return result;
    }

    public Course getRandom(){
        Random random = new Random();
        int index = random.nextInt(_course.size()-1);
        return _course.get(index);
    }

    public List<Course> findByFilter(String request){
        return findByFilter(request,_course);
    }
    public List<Course> findByFilter(String request, List<Course> data){
        request = request.toLowerCase();
        List<Course> result = new ArrayList<>();
        for(Course course: data){
            if(course.get_title().toLowerCase().contains(request)){
                result.add(course);
                continue;
            }
            if(course.get_description().toLowerCase().contains(request)){
                result.add(course);
                continue;
            }
        }
        return result;
    }
}
