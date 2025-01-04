package lviv.syrovyi.footballManager.transfer.service;

import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;

public interface TransferService {
    TransferResponseDTO transfer (TransferRequestDTO transferRequestDTO);
}
