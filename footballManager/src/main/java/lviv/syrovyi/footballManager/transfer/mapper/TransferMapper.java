package lviv.syrovyi.footballManager.transfer.mapper;

import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;
import lviv.syrovyi.footballManager.transfer.repository.entity.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    Transfer mapToEntity(TransferRequestDTO transferRequestDTO);

    TransferResponseDTO mapToDTO(Transfer transfer);
}
