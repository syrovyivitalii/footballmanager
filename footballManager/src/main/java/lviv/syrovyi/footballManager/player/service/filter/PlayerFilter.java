package lviv.syrovyi.footballManager.player.service.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lviv.syrovyi.footballManager.common.util.filter.SearchFilter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
public class PlayerFilter extends SearchFilter {
    Set<BigDecimal> ages;
    Set<BigDecimal> experiences;
}
