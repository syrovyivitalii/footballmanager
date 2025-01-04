package lviv.syrovyi.footballManager.common.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
public class SpecificationCustom {

    public static Specification<? extends BaseEntity> searchFieldInCollectionOfIds(String field, Set<UUID> set) {
        return CollectionUtils.isNotEmpty(set) ?
                (r, rq, cb) -> r.get(field).in(set) :
                null;
    }

    public static <T> Specification<? extends BaseEntity> searchOnField(String fieldName, Set<T> values) {
        return CollectionUtils.isNotEmpty(values) ?
                (root, query, builder) -> root.get(fieldName).in(values) : null;
    }

    public static Specification<? extends BaseEntity> searchLikeString(String propertyName, String name) {
        return Optional.ofNullable(name)
                .filter(StringUtils::isNotBlank)
                .map(property -> (Specification<? extends BaseEntity>)
                        (r, rq, cb) -> cb.like(cb.lower(r.get(propertyName)), "%" + property.toLowerCase().trim() + "%"))
                .orElse(null);
    }

    public static Specification<? extends BaseEntity> searchLikeStringWithJoin(String joinField, String targetField, String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return null;
            }
            Join<Object, Object> join = root.join(joinField, JoinType.LEFT);
            return criteriaBuilder.like(criteriaBuilder.lower(join.get(targetField)), "%" + value.toLowerCase() + "%");
        };
    }
}
