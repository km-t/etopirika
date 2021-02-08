<<<<<<< HEAD
package sample.mybatis.dataaccess;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.mybatis.business.domain.Pet;
import sample.mybatis.business.service.PetDao;

@Repository
public class MyBatisPetDao implements PetDao {

    @Autowired
    private SqlSession ss;
    
    @Override
    public Pet findById(int petId) {
        return ss.selectOne("sample.mybatis.business.service.PetDao.findById", petId);
    }

    @Override
    public List<Pet> findAll() {
        return ss.selectList("sample.mybatis.business.service.PetDao.findAll");
    }

}
=======
package sample.mybatis.dataaccess;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.mybatis.business.domain.Pet;
import sample.mybatis.business.service.PetDao;

@Repository
public class MyBatisPetDao implements PetDao {

    @Autowired
    private SqlSession ss;
    
    @Override
    public Pet findById(int petId) {
        return ss.selectOne("sample.mybatis.business.service.PetDao.findById", petId);
    }

    @Override
    public List<Pet> findAll() {
        return ss.selectList("sample.mybatis.business.service.PetDao.findAll");
    }

}
>>>>>>> fd9e0ee495a0a2213a540a8a7d39a78abd4c0920
