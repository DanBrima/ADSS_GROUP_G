package Repositories;

import Domain.Category;
import Domain.Discount;
import Domain.ProductInStore;
import db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CategoryRepository {
    public void add(Category category) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addDiscount(Category category, Discount discount) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            category.getDiscounts().add(discount);
            session.update(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Category get(String name) {
        return HibernateUtil.getSession().get(Category.class, name) ;
    }

    public Category getFromDB(String name) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Category categoryFromDB = null;

        try {
            categoryFromDB = session.createQuery(
                            "SELECT c FROM Category c LEFT JOIN FETCH c.discounts WHERE c.name = :name",
                            Category.class)
                    .setParameter("name", name)
                    .uniqueResult();;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return categoryFromDB;
    }

    public List<Category> getAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        List<Category> categories = session.createQuery("from Category", Category.class).list();
        session.getTransaction().commit();
        session.close();

        return categories;
    }
}
