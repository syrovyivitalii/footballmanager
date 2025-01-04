package lviv.syrovyi.footballManager.transfer.service;

import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;
import lviv.syrovyi.footballManager.transfer.service.filter.TransferFilter;
import org.springframework.data.domain.Pageable;

public interface TransferService {
    TransferResponseDTO transfer (TransferRequestDTO transferRequestDTO);

    PageResponse<TransferResponseDTO> getTransfersPageable (TransferFilter transferFilter, Pageable pageable);
}
