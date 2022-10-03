package com.codegym.cms.repository;

import com.codegym.cms.model.BlogPrivate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<BlogPrivate> findAll() {
        TypedQuery<BlogPrivate> query = em.createQuery("select b from BlogPrivate b", BlogPrivate.class);
        return query.getResultList();
    }

    @Override
    public BlogPrivate findById(long id) {
        TypedQuery<BlogPrivate>  query = em.createQuery("select b from BlogPrivate b where b.id=:id", BlogPrivate.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

//    @Override
//    public void view(long id) {
//        BlogPrivate blogPrivate = findById(id);
//        if(blogPrivate !=null){
//            em.
//        }
//    }

    @Override
    public void save(BlogPrivate blogPrivate) {
        if(blogPrivate.getId() != null){
            em.merge(blogPrivate);
        } else {
            em.persist(blogPrivate);
        }

    }

    @Override
    public void remove(long id) {
        BlogPrivate blogPrivate = findById(id);
        if(blogPrivate != null){
            em.remove(blogPrivate);
        }

    }
}
