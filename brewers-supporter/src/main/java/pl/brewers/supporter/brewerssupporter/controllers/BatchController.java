package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.brewers.supporter.brewerssupporter.dto.BrewingParamsDTO;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.services.BatchService;

import java.util.List;

@RestController
@RequestMapping("/batches")
@CrossOrigin
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @PostMapping(value = "/{recipeId}/{username}")
    public Batch saveBatch(@RequestBody BrewingParamsDTO brewingParamsDTO,
                           @PathVariable Long recipeId,
                           @PathVariable String username) {
        return batchService.transformRecipe(brewingParamsDTO, recipeId, username);
    }

    @PutMapping(value = "/edit/{batchId}")
    public Batch updateBatch(@RequestBody BrewingParamsDTO brewingParamsDTO,
                             @PathVariable Long batchId) {
        return batchService.updateBatch(brewingParamsDTO, batchId);
    }

    @GetMapping("/{username}")
    public List<Batch> getBatchesByUsername(@PathVariable String username) {
        return batchService.getRecipeByUsername(username);
    }

    @GetMapping("/id/{batchId}")
    public Batch getBatchById(@PathVariable String batchId) {
        return batchService.getBatchById(Long.parseLong(batchId));
    }


}
