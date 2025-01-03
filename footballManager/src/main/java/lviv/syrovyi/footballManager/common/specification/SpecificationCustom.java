package lviv.syrovyi.footballManager.common.specification;

import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public class SpecificationCustom {

    public static Specification<? extends BaseEntity> searchFieldInCollectionOfIds(String field, Set<UUID> set) {
        return CollectionUtils.isNotEmpty(set) ?
                (r, rq, cb) -> r.get(field).in(set) :
                null;
    }
}
