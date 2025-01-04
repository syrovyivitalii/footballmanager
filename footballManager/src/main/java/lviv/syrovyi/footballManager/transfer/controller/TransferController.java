package lviv.syrovyi.footballManager.transfer.controller;

import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;
import lviv.syrovyi.footballManager.transfer.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transfers")
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponseDTO> transfer(TransferRequestDTO transferRequestDTO) {
        TransferResponseDTO transfer = transferService.transfer(transferRequestDTO);

        return ResponseEntity.ok(transfer);
    }
}
