package tp.popotecar.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.popotecar.service.PriceService;
import tp.popotecar.service.dto.PriceDTO;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @PostMapping
    public ResponseEntity<Void> addPrice(
            @RequestBody PriceDTO priceDTO
            ) {
        priceService.addPrice(priceDTO);
        return ResponseEntity.ok().build();
    }
}
