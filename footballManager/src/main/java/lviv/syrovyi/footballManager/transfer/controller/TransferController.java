package lviv.syrovyi.footballManager.transfer.controller;

import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;
import lviv.syrovyi.footballManager.transfer.service.TransferService;
import lviv.syrovyi.footballManager.transfer.service.filter.TransferFilter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<PageResponse<TransferResponseDTO>> getAllTransfersPageable (@ParameterObject TransferFilter transferFilter,
                                                                                      @SortDefault(sort = "createdDate", direction = Sort.Direction.ASC) @ParameterObject Pageable pageable) {
        PageResponse<TransferResponseDTO> transfersPageable = transferService.getTransfersPageable(transferFilter, pageable);

        return ResponseEntity.ok(transfersPageable);
    }
}
