package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class EntityFacade {

    @PersistenceContext(unitName = "ThemeParkDB")
    private EntityManager entityManager;

    public <T> void addEntity(T entity) {
        entityManager.persist(entity);
    }

    public <T> void editEntity(T entity) {
        entityManager.merge(entity);
    }

    public <T> T getEntity(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    public <T> void removeEntity(T entity) {
        entityManager.remove(entity);
    }

    public <T> List<T> getEntities(Class<T> clazz) {
        throw new UnsupportedOperationException("Not implemented yet:(");
    }

    public <T> List<T> getQuery(String queryString, Class<T> clazz) {
        TypedQuery query = entityManager.createNamedQuery(queryString, clazz);
        return query.getResultList();
    }

    public Query getQuery(String queryString) {
        Query query = entityManager.createNamedQuery(queryString);
        return query;
    }

}
