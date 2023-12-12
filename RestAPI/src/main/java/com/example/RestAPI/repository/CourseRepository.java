package com.example.RestAPI.repository;

import com.example.RestAPI.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query(value = "Select * from course c where c.name= :name",nativeQuery = true)
    List<Course> findByName(@Param("name") String name);








  /*  Sr.No	Method & Description
1
    count(): long

    returns the number of entities available.

            2
    delete(Employee entity): void

    deletes an entity.

3
    deleteAll():void

    deletes all the entities.

            4
    deleteAll(Iterable< extends Employee > entities):void

    deletes the entities passed as argument.

            5
    deleteAll(Iterable< extends Integer > ids):void

    deletes the entities identified using their ids passed as argument.

            6
    existsById(Integer id):boolean

    checks if an entity exists using its id.

            7
    findAll():Iterable< Employee >

    returns all the entities.

            8
    findAllByIds(Iterable< Integer > ids):Iterable< Employee >

    returns all the entities identified using ids passed as argument.

            9
    findById(Integer id):Optional< Employee >

    returns an entity identified using id.

            10
    save(Employee entity): Employee

    saves an entity and return the updated one.

11
    saveAll(Iterable< Employee> entities): Iterable< Employee>

    saves all entities passed and return the updated entities.


     */

}
