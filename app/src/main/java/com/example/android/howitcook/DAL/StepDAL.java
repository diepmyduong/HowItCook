package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Step;
import com.example.android.howitcook.Model.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Admin on 23/12/2015.
 */
public class StepDAL {
//    private List<Step> _step;

    public StepDAL(){
//        _step = new ArrayList<Step>();
//
//        _step.add(new Step(1,1,1,"Cá điêu hồng làm sạch, cắt khúc."));
//        _step.add(new Step(2,1,2,"Măng chua làm sạch, cắt lát xong xào với tỏi nêm ít muối, đường."));
//        _step.add(new Step(3,1,3,"Cà chua xắt múi cau."));
//        _step.add(new Step(4,1,4,"Me pha lấy nước."));
//        _step.add(new Step(5,1,5,"Ngò gai, ngò ôm xắt khúc."));
//        _step.add(new Step(6,1,6,"Tỏi băm nhuyễn, hành tím xắt lát mỏng."));
//        _step.add(new Step(7,1,7,"Ớt sừng xắt lát."));
//        _step.add(new Step(8,1,8,"Đầu tiên cho ít dầu ăn, phi thơm tỏi, hành tím xong cho 2 trái cà chua múi cau vào xào cho thơm và lấy màu."));
//        _step.add(new Step(9,1,9,"Tiếp theo cho cá vào xào cho săn, cho nước vào nồi và nêm 1 gói gia vị Barona vào."));
//        _step.add(new Step(10,1,10,"Cho măng xào vào canh, 2 trái ớt hiểm đập dập và nêm đường và nước cốt me vào."));
//        _step.add(new Step(11,1,11,"Cá chín, cho 2 trái cà chua múi cau vào tắt lửa."));
//        _step.add(new Step(12,1,12,"Khi ăn rắc ngò gai, ớt sừng xắt lát và ngò ôm lên trên."));
    }


    public List<Step> getAllList(){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Step> query = realm.where(Step.class);
        RealmResults<Step> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
//        return _step;
    }

    public Step findById(int id){
//        for (Step step:_step) {
//            if(step.get_id() == id){
//                return step;
//            }
//        }
//        return  null;
        Realm realm = Realm.getDefaultInstance();
        Step result = realm.where(Step.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }

    public List<Step> findByCourse(int id){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Step> query = realm.where(Step.class).equalTo("_courseID",id);
        RealmResults<Step> models = query.findAll();
        models.sort("_rank");
        realm.close();
        return  models.subList(0,models.size());
//        List<Step> result = new ArrayList<>();
//        for(Step step:_step){
//            if(step.get_courseID() == id){
//                result.add(step);
//            }
//        }

//        //Sort by rank
//        Collections.sort(result, new Comparator<Step>() {
//            public int compare(Step self, Step other) {
//                // I'm assuming your Employee.id is an Integer not an int.
//                // If you'd like to use int, create an Integer before calling compareTo.
//                if (self.get_rank() > other.get_rank()) {
//                    return 1;
//                } else if (self.get_rank() < other.get_rank()) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
//        return result;
    }
}
