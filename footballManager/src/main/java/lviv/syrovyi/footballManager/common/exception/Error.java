package lviv.syrovyi.footballManager.common.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Data
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
@FieldDefaults(level = PROTECTED)
public class Error {
    String message;
}
